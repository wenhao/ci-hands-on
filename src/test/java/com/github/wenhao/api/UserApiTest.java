/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.api;

import com.github.wenhao.api.view.UserView;
import com.github.wenhao.domain.User;
import com.github.wenhao.mapper.UserMapper;
import com.github.wenhao.service.UserRemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class UserApiTest
{

    @InjectMocks
    private UserApi userApi;
    @Mock
    private UserRemoteService userRemoteService;
    @Mock
    private UserMapper userMapper;

    @Test
    public void should_get_user_information()
    {
        // given
        String userId = "ahbei";
        User user = new User();
        when(userRemoteService.get(userId)).thenReturn(Optional.of(user));
        when(userMapper.map(user, UserView.class)).thenReturn(new UserView());

        // when
        ResponseEntity<UserView> response = userApi.get(userId);

        // then
        assertThat(response.getStatusCode()).isEqualTo(OK);
    }

    @Test
    public void should_get_not_found_error_when_user_id_not_exist()
    {
        // given
        String userId = "not-exist-user";
        when(userRemoteService.get(userId)).thenReturn(Optional.empty());

        // when
        ResponseEntity<UserView> response = userApi.get(userId);

        // then
        assertThat(response.getStatusCode()).isEqualTo(NOT_FOUND);
    }
}
