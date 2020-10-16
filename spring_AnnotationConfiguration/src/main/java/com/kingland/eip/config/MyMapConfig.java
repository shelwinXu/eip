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
public class MyMapConfig {
    @Bean
    @Order(11)
    public Integer integer1() {
        return 1;
    }

    @Bean
    @Order(17)
    public Integer integer2() {
        return 2;
    }

    @Bean
    @Order(1)
    public Integer integer3() {
        return 3;
    }
}
