/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * define a ApplicationContext class mock the IOC
 */
public class ApplicationContext implements BeanFactory{

    private final Map<String,Object> beanByNameMap = new ConcurrentHashMap<>();

    private final Map<Class<?>,Object> beanByClassMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return beanByNameMap.get(name);
    }

    @Override
    public <T> T getBean(Class<T> tClass) {
        return tClass.cast(beanByClassMap.get(tClass));
    }

    @Override
    public void setBean(String id,Class<?> tClass) {
        if (tClass == null){
            throw new IllegalArgumentException("This class is null");
        }
        Object obj = null;
        try {
            obj = tClass.getDeclaredConstructor(id.getClass()).newInstance(id);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        beanByNameMap.put(id,obj);
    }

    @Override
    public void setBean(String id,Class<?> tClass,String containId) {

        if (id == null ||id.isEmpty()){
            throw new RuntimeException("This id could not be null");
        }

        if (tClass == null){
            throw new RuntimeException("This class could not be null");
        }
        Object containObj = beanByNameMap.get(containId);
        if (containObj == null) {
            throw new RuntimeException("This contain class could not be null");
        }

        Object obj = null;
        try {
            obj = tClass.getDeclaredConstructor(containObj.getClass(),id.getClass()).newInstance(containObj,id);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        beanByNameMap.put(id,obj);
    }
}
