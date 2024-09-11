package com.sz.platform.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatisflex.core.exception.FlexExceptions;
import com.mybatisflex.core.handler.BaseJsonTypeHandler;
import com.sz.core.util.SpringApplicationContextUtils;

import java.io.IOException;
import java.util.Collection;

/**
 *  自定义JacksonTypeHandler，使用全局Jackson配置
 * @ClassName SzJacksonTypeHandler
 * @Author sz
 * @Date 2024/9/11 16:51
 * @Version 1.0
 */
public class SzJacksonTypeHandler extends BaseJsonTypeHandler {
    private static ObjectMapper objectMapper;
    private final Class<?> propertyType;
    private Class<?> genericType;
    private JavaType javaType;

    public SzJacksonTypeHandler(Class<?> propertyType) {
        this.propertyType = propertyType;
    }

    public SzJacksonTypeHandler(Class<?> propertyType, Class<?> genericType) {
        this.propertyType = propertyType;
        this.genericType = genericType;
    }

    @Override
    protected Object parseJson(String json) {
        try {
            if (genericType != null && Collection.class.isAssignableFrom(propertyType)) {
                return getObjectMapper().readValue(json, getJavaType());
            } else {
                return getObjectMapper().readValue(json, propertyType);
            }
        } catch (IOException e) {
            throw FlexExceptions.wrap(e, "Can not parseJson by JacksonTypeHandler: " + json);
        }
    }

    @Override
    protected String toJson(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw FlexExceptions.wrap(e, "Can not convert object to Json by JacksonTypeHandler: " + object);
        }
    }

    public JavaType getJavaType() {
        if (javaType == null) {
            javaType = getObjectMapper().getTypeFactory().constructCollectionType((Class<? extends Collection>) propertyType, genericType);
        }
        return javaType;
    }

    public static ObjectMapper getObjectMapper() {
        if (null == objectMapper) {
            // 使用全局jackson配置
            objectMapper = SpringApplicationContextUtils.getBean("jacksonObjectMapper");
        }
        return objectMapper;
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        // 使用全局jackson配置
        SzJacksonTypeHandler.objectMapper = SpringApplicationContextUtils.getBean("jacksonObjectMapper");
    }
}
