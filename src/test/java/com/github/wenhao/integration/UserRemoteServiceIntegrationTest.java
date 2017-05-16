/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.integration;

import com.github.wenhao.domain.User;
import com.github.wenhao.service.UserRemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserRemoteServiceIntegrationTest
{
    @Autowired
    private UserRemoteService userRemoteService;

    @Test
    public void should_get_user_information() {
        // given

        // when
        Optional<User> userOptional = userRemoteService.get("ahbei");

        // then
        assertThat(userOptional.isPresent()).isEqualTo(true);
    }
}