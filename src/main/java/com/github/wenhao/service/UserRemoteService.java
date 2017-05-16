/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.service;

import com.github.wenhao.config.RemoteConfig;
import com.github.wenhao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserRemoteService
{
    private RestTemplate restTemplate;
    private RemoteConfig remoteConfig;

    @Autowired
    public UserRemoteService(final RestTemplate restTemplate, final RemoteConfig remoteConfig)
    {
        this.restTemplate = restTemplate;
        this.remoteConfig = remoteConfig;
    }

    public Optional<User> get(final String userId)
    {
        String url = remoteConfig.getDoubanUserGetUrl() + userId;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return Optional.ofNullable(response.getBody());
        }
        return Optional.empty();
    }
}
