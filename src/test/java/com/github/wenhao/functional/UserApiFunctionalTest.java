/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.functional;

import com.github.wenhao.helper.RemoteConfigHelper;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserApiFunctionalTest
{
    @Test
    public void should_get_user_information()
    {
        String url = RemoteConfigHelper.getInstance().get("douban-user-get-url");

        given().
        when().
            get(url + "ahbei").
        then().
            body("title", equalTo("阿北"));
    }
}
