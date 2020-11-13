package com.kingland.eip.datasource;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFileSourceTest {

    static ReadFileSource readFileSource;

    @Test
    public void shouldReadFileSourceSuccessByExistFile() throws IOException {
        String filePath = "src/main/resources/Files/dataSource.txt";
        readFileSource = new ReadFileSource();

        BufferedReader br = readFileSource.readSource(filePath);

        assertNotNull(br);
        assertTrue(br.ready());
    }

    @Test
    public void shouldReadFileSourceByNotExistFile()  {
        String filePath = "src/main/resources/Files/dataSource1.txt";
        readFileSource = new ReadFileSource();

        BufferedReader br = readFileSource.readSource(filePath);

        assertNull(br);
    }

    @Test
    public void shouldReadFileSourceThrowsException() {
        String filePath1 = "src/main/resources/Files/test1.txt";
        String filePath2 = "src/main/resources/Files/test2.txt";

        readFileSource = new ReadFileSource();

        Exception exception = assertThrows(RuntimeException.class, ()->{
            readFileSource.readSource(filePath1,filePath2);
        });
        String expectedType = "RuntimeException";
        String expectedMessage = "The File source's path is not valid!";
        String actualType = exception.getClass().toString();
        String actualMessage = exception.getMessage();
        assertNotNull(exception);
        assertTrue(actualType.contains(expectedType));
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
