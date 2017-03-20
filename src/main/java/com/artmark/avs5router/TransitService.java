package com.artmark.avs5router;

import com.artmark.avs5router.domain.HostRepository;
import com.artmark.avs5router.domain.model.Host;
import com.artmark.avs5router.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nikolay on 20.03.17.
 */
@Service
public class TransitService {
	@Autowired
	private HostRepository hostRepository;
	@Autowired
	private RestTemplate restTemplate;

	public TransitBookResponse book(TransitBookRequest request) {
		RouteKey routeKey = request.getRouteKey();
		Host host = hostRepository.getHostByDepotUid(routeKey.getDispatchStationUid())
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
		return restTemplate.postForObject(host.getUrl() + "/transit/book", request, TransitBookResponse.class);
	}

	public TransitConfirmResponse confirm(TransitConfirmRequest request) {
		RouteKey routeKey = request.getRouteKey();
		Host host = hostRepository.getHostByDepotUid(routeKey.getDispatchStationUid())
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
		return restTemplate.postForObject(host.getUrl() + "/transit/cancel", request, TransitConfirmResponse.class);
	}

	public TransitCancelResponse cancel(TransitCancelRequest request) {
		RouteKey routeKey = request.getRouteKey();
		Host host = hostRepository.getHostByDepotUid(routeKey.getDispatchStationUid())
				.orElseThrow(()->new TransitException("Мастер-сервер не найден"));
		return restTemplate.postForObject(host.getUrl() + "/transit/cancel", request, TransitCancelResponse.class);
	}
}
