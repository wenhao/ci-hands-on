package com.github.wenhao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:remote.properties")
@ConfigurationProperties
public class RemoteConfig
{
    private String doubanUserGetUrl;

    public String getDoubanUserGetUrl() {
        return doubanUserGetUrl;
    }

    public void setDoubanUserGetUrl(final String doubanUserGetUrl) {
        this.doubanUserGetUrl = doubanUserGetUrl;
    }

}
