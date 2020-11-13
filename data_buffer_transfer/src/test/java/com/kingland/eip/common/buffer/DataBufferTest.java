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
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            dataBuffer = new DataBuffer(-1);
        });

        String expectedType = "java.lang.IllegalArgumentException";
        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }

    @Test
    public void shouldEnqueueSuccess() throws Exception {
        dataBuffer.enqueue(dataList);
        assertEquals(dataList.size(),dataBuffer.dequeue(dataList.size()).size());
    }

    @Test
    public void shouldEnqueueHaveException() throws Exception {
        dataBuffer.setStatus(DataBufferStatus.EnqueueError);

        Exception exception = assertThrows(Exception.class, ()->{
            dataBuffer.enqueue(dataList);
        });

        String expectedType = "java.lang.Exception";

        assertNotNull(exception);
        assertTrue(exception.getClass().toString().contains(expectedType));
    }

    @Test
    public void shouldEnqueueCauseFullBuffer() {
        dataList.add("test string");

        //this assert can be failed,because the wait time is 3000.
        assertTimeoutPreemptively(ofMillis(3000), () -> {
            dataBuffer.enqueue(dataList);
        });
    }

    @Test
    public void shouldNullBufferDequeueSuccess() throws Exception {
        List dequeueList = dataBuffer.dequeue(dataList.size());

        assertEquals(0,dequeueList.size());
        assertEquals(dataBuffer.getStatus(),DataBufferStatus.DequeueCompleted);
    }

    @Test
    public void shouldNotNullBufferDequeueSuccess() throws Exception {
        dataBuffer.enqueue(dataList);
        List dequeueList = dataBuffer.dequeue(dataList.size());
        assertEquals(dataList.size(),dequeueList.size());
        assertEquals(dataBuffer.getStatus(),DataBufferStatus.Active);
    }

}
