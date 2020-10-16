/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * @author KSC
 */
@Component
@Lazy
public class MyListConfig {

    @Bean
    @Order(11)
    public String string1(){
        return "String-1";
    }

    @Bean
    @Order(22)
    public String string2(){
        return "String-2";
    }

    @Bean
    @Order(29)
    public String string3(){
        return "String-3";
    }
}
