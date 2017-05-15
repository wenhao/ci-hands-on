package com.github.wenhao.mapper;

import com.github.wenhao.api.view.UserView;
import com.github.wenhao.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper
{

    public UserMapper() {
        register(User.class, UserView.class);
    }
}
