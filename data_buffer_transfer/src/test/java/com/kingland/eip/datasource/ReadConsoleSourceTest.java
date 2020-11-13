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
        BufferedReader br = readConsoleSource.readSource();

        assertNotNull(br);
        assertTrue(br.ready());
    }

    @Test
    public void shouldReadConsoleSourceThrowsException() {
        String filePath1 = "src/main/resources/Files/test1.txt";

        readConsoleSource = new ReadConsoleSource();

        Exception exception = assertThrows(RuntimeException.class, ()->{
            readConsoleSource.readSource(filePath1);
        });
        String expectedType = "RuntimeException";
        String expectedMessage = "Console source does not need a file path!";
        String actualType = exception.getClass().toString();
        String actualMessage = exception.getMessage();
        assertNotNull(exception);
        assertTrue(actualType.contains(expectedType));
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
