package com.artmark.avs5router;

import com.artmark.avs5router.domain.HostRepository;
import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

/**
 * Created by nikolay on 20.03.17.
 */
@Service
public class TransitService {
	@Autowired
	private HostRepository hostRepository;

	private RestTemplate getRestTemplate(Host host) {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(host.getUsername(), host.getPassword()));
        DefaultUriTemplateHandler uriTemplateHandler = new DefaultUriTemplateHandler();
        if ("avs5".equalsIgnoreCase(host.getEngine())) {
            uriTemplateHandler.setBaseUrl(host.getUrl() + "/soap/rs");
        } else if ("avs5rs".equalsIgnoreCase(host.getEngine())) {
            uriTemplateHandler.setBaseUrl(host.getUrl());
        }
        restTemplate.setUriTemplateHandler(uriTemplateHandler);
		return restTemplate;
	}

	private Host getHost(RouteKey routeKey) {
		return hostRepository.getHostByDepotUid(routeKey.getDispatchStationUid())
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
	}

	public TransitBookResponse book(TransitBookRequest request) {
		Host host = getHost(request.getRouteKey());
		return getRestTemplate(host).postForObject("/transit/book", request, TransitBookResponse.class);
	}

	public TransitConfirmResponse confirm(TransitConfirmRequest request) {
		Host host = getHost(request.getRouteKey());
		return getRestTemplate(host).postForObject("/transit/confirm", request, TransitConfirmResponse.class);
	}

	public TransitCancelResponse cancel(TransitCancelRequest request) {
		Host host = getHost(request.getRouteKey());
		return getRestTemplate(host).postForObject("/transit/cancel", request, TransitCancelResponse.class);
	}

	public GetFreeSeatsResponse getFreeSeats(GetFreeSeatsRequest request) {
		Host host = getHost(request.getRouteKey());
		return getRestTemplate(host).postForObject("/transit/getFreeSeats", request, GetFreeSeatsResponse.class);
	}
}
