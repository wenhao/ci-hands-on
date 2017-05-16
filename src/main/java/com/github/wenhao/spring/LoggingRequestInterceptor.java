/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

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
    private static final Logger LOG = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(final HttpRequest httpRequest, final byte[] bytes,
                                        final ClientHttpRequestExecution clientHttpRequestExecution) throws IOException
    {
        LOG.debug("################################ LoggingRequestInterceptor Start #################################");
        traceRequest(httpRequest, bytes);
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        traceResponse(response);
        LOG.debug("################################ LoggingRequestInterceptor End ###################################");
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException
    {
        LOG.debug("### Request ###");
        LOG.debug("URI : " + request.getURI());
        LOG.debug("Method : " + request.getMethod());
        LOG.debug("Headers : " + request.getHeaders());
        if (request.getMethod().equals(HttpMethod.GET)) {
            return;
        }
        LOG.debug("Request Body : " + new String(body, "UTF-8"));
    }

    private void traceResponse(ClientHttpResponse response) throws IOException
    {
        LOG.debug("### Response ###");
        LOG.debug("Status code: " + response.getStatusCode());
        LOG.debug("Status text: " + response.getStatusText());
        LOG.debug("Headers : " + response.getHeaders());
    }
}
