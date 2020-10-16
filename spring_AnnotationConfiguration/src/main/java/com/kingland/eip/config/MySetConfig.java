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
public class MySetConfig {

    @Bean
    @Order(43)
    public String string1(){
        return "String-1";
    }

    @Bean
    @Order(10)
    public String string2(){
        return "String-2";
    }

    @Bean
    @Order(66)
    public String string3(){
        return "String-3";
    }
}
