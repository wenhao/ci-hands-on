/*
 * Copyright (c) 2017. All rights reserved. Used by permission.
 *
 * Author: Wen Hao
 * Date: 2017-05-16 17:34:12
 * Gtihub: https://github.com/wenhao
 *
 */

package com.github.wenhao.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class BaseMapper
{
    private final MapperFactory mapperFactory;

    protected BaseMapper()
    {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    protected void register(Class<?> typeA, Class<?> typeB)
    {
        mapperFactory.classMap(typeA, typeB)
            .byDefault()
            .register();
    }

    public <T> T map(Object obj, Class<T> targetType)
    {
        return mapperFactory.getMapperFacade().map(obj, targetType);
    }
}
