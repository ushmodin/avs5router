package com.artmark.avs5router;

import com.artmark.avs5router.domain.model.Host;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

/**
 * @author Ushmodin N.
 * @since 03.05.2017 13:25
 */

@Component
public class RestTemplateRepository {

    public static final int CONNECT_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 20000;

    @Cacheable("rest-templates")
    public RestTemplate getRestTemplate(Host host) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(CONNECT_TIMEOUT);
        requestFactory.setReadTimeout(READ_TIMEOUT);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(host.getUsername(), host.getPassword()));
        restTemplate.getInterceptors().add(new RequestLoggerInterceptor());
        DefaultUriTemplateHandler uriTemplateHandler = new DefaultUriTemplateHandler();
        if ("avs5".equalsIgnoreCase(host.getEngine())) {
            uriTemplateHandler.setBaseUrl(host.getUrl() + "/soap/rs");
        } else if ("avs5rs".equalsIgnoreCase(host.getEngine())) {
            uriTemplateHandler.setBaseUrl(host.getUrl());
        }
        restTemplate.setUriTemplateHandler(uriTemplateHandler);
        return restTemplate;
    }
}
