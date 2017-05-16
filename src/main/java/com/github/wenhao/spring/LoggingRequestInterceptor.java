package com.github.wenhao.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor
{
    private static final Logger log = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(final HttpRequest httpRequest, final byte[] bytes, final ClientHttpRequestExecution clientHttpRequestExecution) throws IOException
    {
        log.debug("#################################### LoggingRequestInterceptor Start ###################################");
        traceRequest(httpRequest, bytes);
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        traceResponse(response);
        log.debug("#################################### LoggingRequestInterceptor End ###################################");
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException
    {
        log.debug("=========================== Tracing request ================================================");
        log.debug("URI : " + request.getURI());
        log.debug("Method : " + request.getMethod());
        log.debug("Headers : " + request.getHeaders());
        if (request.getMethod().equals(HttpMethod.GET)) {
            return;
        }
        log.debug("Request Body : " + new String(body, "UTF-8"));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException
    {
        log.debug("=========================== Tracing Response =============================================");
        log.debug("Status code: " + response.getStatusCode());
        log.debug("Status text: " + response.getStatusText());
        log.debug("Headers : " + response.getHeaders());
    }
}
