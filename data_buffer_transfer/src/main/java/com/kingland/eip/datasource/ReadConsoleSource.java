/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadConsoleSource implements ReadSource{
    @Override
    public BufferedReader readSource(String ...path) {
        if (path.length > 0){
            throw new RuntimeException("Console source does not need a file path!");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text:");
        System.out.println("Enter 'end' to quit:");
        return br;
    }
}
