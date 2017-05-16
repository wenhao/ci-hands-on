/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.mapper;

import com.github.wenhao.api.view.UserView;
import com.github.wenhao.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper
{

    public UserMapper()
    {
        register(User.class, UserView.class);
    }
}
