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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("users")
public class UserApi
{

    private UserRemoteService userRemoteService;
    private UserMapper userMapper;

    @Autowired
    public UserApi(final UserRemoteService userRemoteService, final UserMapper userMapper)
    {
        this.userRemoteService = userRemoteService;
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/{user_id}", method = GET)
    public ResponseEntity<UserView> get(@PathVariable("user_id") final String userId)
    {
        Optional<User> userOptional = userRemoteService.get(userId);
        if (userOptional.isPresent()) {
            UserView userView = userMapper.map(userOptional.get(), UserView.class);
            return ResponseEntity.ok(userView);
        }
        return ResponseEntity.notFound().build();
    }
}
