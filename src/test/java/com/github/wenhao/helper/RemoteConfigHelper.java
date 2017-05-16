/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:41:44
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.isNull;

public class RemoteConfigHelper
{

    private static final String CONFIG = "/remote.properties";
    private final static RemoteConfigHelper remoteConfigHelper = new RemoteConfigHelper();
    private Properties properties;

    private RemoteConfigHelper()
    {
    }

    public static RemoteConfigHelper getInstance()
    {
        return remoteConfigHelper;
    }

    public String get(String key)
    {
        loadProperties();
        return properties.getProperty(key);
    }

    private void loadProperties()
    {
        try {
            if (isNull(properties)) {
                properties = new Properties();
                InputStream resourceAsStream = this.getClass().getResourceAsStream(CONFIG);
                properties.load(resourceAsStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not load config.", e);
        }
    }
}
