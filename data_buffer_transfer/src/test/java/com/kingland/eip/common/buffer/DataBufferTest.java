/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.common.buffer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void shouldEnqueueSuccess() throws Exception {
        dataBuffer.enqueue(dataList);
    }

}
