package com.github.wenhao.service;

import com.github.wenhao.config.RemoteConfig;
import com.github.wenhao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserRemoteService
{
    private RestTemplate restTemplate;
    private RemoteConfig remoteConfig;

    @Autowired
    public UserRemoteService(final RestTemplate restTemplate, final RemoteConfig remoteConfig) {
        this.restTemplate = restTemplate;
        this.remoteConfig = remoteConfig;
    }

    public Optional<User> get(final String userId) {
        User user = restTemplate.getForObject(remoteConfig.getDoubanUserGetUrl() + userId, User.class);
        return Optional.ofNullable(user);
    }
}
