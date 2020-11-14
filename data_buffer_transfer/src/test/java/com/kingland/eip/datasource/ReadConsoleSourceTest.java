/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadConsoleSourceTest {
    private ReadConsoleSource readConsoleSource;

    @Test
    public void shouldReadFileSourceByNotExistFile() throws IOException {
        //given some strings analog console input
        readConsoleSource = new ReadConsoleSource();
        String data = "Hello, World!\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());
        } finally {
            System.setIn(stdin);
        }
        //when BufferedReader read source
        BufferedReader br = readConsoleSource.readSource();

        //then BufferedReader is not null and ready
        assertNotNull(br);
        assertTrue(br.ready());
    }

    @Test
    public void shouldReadConsoleSourceThrowsException() {
        //given the extra data source filepath and try to read the source
        String filePath1 = "src/main/resources/Files/test1.txt";
        readConsoleSource = new ReadConsoleSource();

        //when readConsoleSource start to read the source
        Exception exception = assertThrows(RuntimeException.class, ()->{
            readConsoleSource.readSource(filePath1);
        });

        //then handle the RuntimeException
        String expectedType = "java.lang.RuntimeException";
        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }
}
