/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.bean;

import java.lang.reflect.InvocationTargetException;

/**
 * define a bean factory interface
 *
 *  @author KSC
 */
public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(Class<T> tClass);

    //void setBean(String fieldName,Class<?> tClass);
    //
    //void setBean(String fieldName,Class<?> tClass,String containId);

    void setBean(String fieldName,Class<?> tClass,String ...refIds);

}
