package com.github.wenhao.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public abstract class BaseMapper
{
    protected final MapperFactory mapperFactory;

    protected BaseMapper() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    protected void register(Class<?> typeA, Class<?> typeB) {
        mapperFactory.classMap(typeA, typeB)
                .byDefault()
                .register();
    }

    public <T> T map(Object obj, Class<T> targetType) {
        return mapperFactory.getMapperFacade().map(obj, targetType);
    }
}
