/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.bean;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * define a ApplicationContext class mock the IOC
 *
 * @author KSC
 */
public class ApplicationContext implements BeanFactory{

    private final Map<String,Object> beanByNameMap = new ConcurrentHashMap<>();

    private final Map<Class<?>,Object> beanByClassMap = new ConcurrentHashMap<>();

    /**
     * get bean by bean id
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        return beanByNameMap.get(name);
    }

    /**
     * get bean by class
     * @param tClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getBean(Class<T> tClass) {
        return tClass.cast(beanByClassMap.get(tClass));
    }

    /**
     * set bean by id、class、refIds
     * @param id bean id
     * @param tClass class type
     * @param refIds ref Ids
     */
    public void setBean(String id,Class<?> tClass,String ...refIds) {
        if (id == null || id.isEmpty()){
            throw new RuntimeException("The refIds could not be null");
        }

        if (tClass == null){
            throw new RuntimeException("This class could not be null");
        }
        Object[] objects = null;

        if (refIds.length != 0){
            objects = new Object[refIds.length];
            for (int i = 0; i < refIds.length; i++) {
                objects[i] = getBean(refIds[i]);
            }
        }

        Constructor<?>[] constructors = tClass.getConstructors();
        Object bean = null;
        for (Constructor<?> constructor : constructors) {
            try {
                bean = constructor.newInstance(objects);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (bean != null){
                break;
            }
        }
        beanByNameMap.put(id, bean);
    }
}
