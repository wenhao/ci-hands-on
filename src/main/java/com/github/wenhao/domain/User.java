/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User
{
    private String id;
    private String uid;
    private String title;
    private String homepage;
    private String icon;

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(final String uid)
    {
        this.uid = uid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getHomepage()
    {
        return homepage;
    }

    public void setHomepage(final String homepage)
    {
        this.homepage = homepage;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(final String icon)
    {
        this.icon = icon;
    }
}
