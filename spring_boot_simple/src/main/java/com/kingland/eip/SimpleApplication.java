/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author KSC
 */
@SpringBootApplication
@MapperScan("com.kingland.eip.mapper")
public class SimpleApplication {
    public static void main(String[] args) {

        SpringApplication.run(SimpleApplication.class, args);
    }
}