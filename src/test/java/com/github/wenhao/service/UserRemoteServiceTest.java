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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRemoteServiceTest
{
    @InjectMocks
    private UserRemoteService userRemoteService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private RemoteConfig remoteConfig;

    @Test
    public void should_get_user_by_call_douban_user_api() {
        // given
        final String userId = "ahbei";
        when(remoteConfig.getDoubanUserGetUrl()).thenReturn("user/");
        when(restTemplate.getForEntity("user/ahbei", User.class)).thenReturn(ResponseEntity.ok(new User()));

        // when
        Optional<User> userOptional = userRemoteService.get(userId);

        // then
        assertThat(userOptional.isPresent()).isEqualTo(true);
    }

    @Test
    public void should_get_empty_user_when_user_not_exist() {
        // given
        final String userId = "ahbei";
        when(remoteConfig.getDoubanUserGetUrl()).thenReturn("user/");
        when(restTemplate.getForEntity("user/ahbei", User.class)).thenReturn(ResponseEntity.notFound().build());

        // when
        Optional<User> userOptional = userRemoteService.get(userId);

        // then
        assertThat(userOptional.isPresent()).isEqualTo(false);
    }
}