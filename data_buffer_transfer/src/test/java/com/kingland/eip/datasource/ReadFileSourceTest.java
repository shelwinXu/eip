package com.kingland.eip.datasource;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFileSourceTest {

    static ReadFileSource readFileSource;

    @Test
    public void shouldReadFileSourceSuccessByExistFile() throws IOException {
        //given data source filepath
        String filePath = "src/main/resources/Files/dataSource.txt";
        readFileSource = new ReadFileSource();

        //when begin to read the source
        BufferedReader br = readFileSource.readSource(filePath);

        //then read source successfully
        assertNotNull(br);
        assertTrue(br.ready());
    }

    @Test
    public void shouldReadFileSourceByNotExistFile()  {
        //given data source filepath
        String filePath = "src/main/resources/Files/dataSource1.txt";
        readFileSource = new ReadFileSource();

        //when begin to read the source
        BufferedReader br = readFileSource.readSource(filePath);

        assertNull(br);
    }

    @Test
    public void shouldReadFileSourceThrowsException() {
        //given the extra data source filepath and try to read the source
        String filePath1 = "src/main/resources/Files/test1.txt";
        String filePath2 = "src/main/resources/Files/test2.txt";

        readFileSource = new ReadFileSource();

        //when readConsoleSource start to read the source
        Exception exception = assertThrows(RuntimeException.class, ()->{
            readFileSource.readSource(filePath1,filePath2);
        });

        //then handle the RuntimeException
        String expectedType = "java.lang.RuntimeException";
        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }
}
