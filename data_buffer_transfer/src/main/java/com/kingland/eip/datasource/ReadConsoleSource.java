/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

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

    public Stream<InputStreamReader> readStream(String ...path) {
        if (path.length > 0){
            throw new RuntimeException("Console source does not need a file path!");
        }
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stream<InputStreamReader> readerStream = Stream.of(new InputStreamReader(System.in));
        System.out.println("Enter lines of text:");
            System.out.println("Enter 'end' to quit:");
            return readerStream;
    }
}
