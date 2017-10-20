package com.artmark.avs5router.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            traceResponse(response);
        }
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.trace("URI: " + request.getURI()
                + " Request body: " + new String(body, "UTF-8"));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            buffer.append(line);
            buffer.append('\n');
            line = reader.readLine();
        }
        response.getBody().reset();
        log.trace("Status code: " + response.getStatusCode()
                + " Response body: " + buffer.toString());
    }

}
