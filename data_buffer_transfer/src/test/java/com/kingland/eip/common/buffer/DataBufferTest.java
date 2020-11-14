/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.common.buffer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class DataBufferTest {
    private static DataBuffer dataBuffer;

    private static List dataList = new ArrayList();

    @BeforeAll
    public static void initBuffer() {
        //init DataBuffer and add data
        int capacity = 5;
        dataBuffer = new DataBuffer(capacity);
        for (int i = 0; i < capacity; i++) {
            dataList.add("test string");
        }
    }

    @Test
    public void shouldConstructorSuccess(){
        assertEquals(dataBuffer.getStatus(),DataBufferStatus.Active);
    }

    @Test
    public void shouldConstructorHaveException(){
        //when give the invalid capacity
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            dataBuffer = new DataBuffer(-1);
        });

        //then throws the IllegalArgumentException
        String expectedType = "java.lang.IllegalArgumentException";
        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }

    @Test
    public void shouldEnqueueSuccess() throws Exception {
        //when dataBuffer enqueue data
        dataBuffer.enqueue(dataList);

        //then the size is equals to the data size in dataBuffer
        assertEquals(dataList.size(),dataBuffer.dequeue(dataList.size()).size());
    }

    @Test
    public void shouldEnqueueHaveException() throws Exception {
        //given DataBufferStatus is EnqueueError
        dataBuffer.setStatus(DataBufferStatus.EnqueueError);

        //when dataBuffer enqueue the data
        Exception exception = assertThrows(Exception.class, ()->{
            dataBuffer.enqueue(dataList);
        });

        //then throws the exception
        String expectedType = "java.lang.Exception";
        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }

    @Test
    public void shouldEnqueueCauseFullBuffer() {
        //when add data make databuffer is full
        dataList.add("test string");

        //then assert can be failed,because this wait time is more than 3000.
        assertTimeoutPreemptively(ofMillis(3000), () -> {
            dataBuffer.enqueue(dataList);
        });
    }

    @Test
    public void shouldNullBufferDequeueSuccess() throws Exception {
        //when dequeue the all the data
        List dequeueList = dataBuffer.dequeue(dataList.size());

        //then dequeueList size is 0 and DataBufferStatus is DequeueCompleted
        assertEquals(0,dequeueList.size());
        assertEquals(dataBuffer.getStatus(),DataBufferStatus.DequeueCompleted);
    }

    @Test
    public void shouldNotNullBufferDequeueSuccess() throws Exception {
        //given data into the dataBuffer
        dataBuffer.enqueue(dataList);

        //when the dataBuffer dequeue data
        List dequeueList = dataBuffer.dequeue(dataList.size());

        //then DataBufferStatus is Active
        assertEquals(dataList.size(),dequeueList.size());
        assertEquals(dataBuffer.getStatus(),DataBufferStatus.Active);
    }

}
