package com.artmark.avs5router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author Ushmodin N.
 * @since 03.05.2017 14:44
 */

public class RequestLoggerInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger("com.artmark.avs5router.CONTENT");

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        if (log.isTraceEnabled()) {
            traceRequest(httpRequest, bytes);
        }
        ClientHttpResponse response = execution.execute(httpRequest, bytes);
        if (log.isTraceEnabled()) {
            traceResponse(response, bytes);
        }
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.trace("URI: " + request.getURI()
                + " Request body: " + new String(body, "UTF-8"));
    }

    private void traceResponse(ClientHttpResponse response, byte[] body) throws IOException {
        log.trace("Status code: " + response.getStatusCode()
                + " Response body: " + new String(body, "UTF-8"));
    }

}
