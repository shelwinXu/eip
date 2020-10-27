/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.common.buffer.DataBufferStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataLoaderTest {
    static BufferedReader br;

    static DataBuffer dataBuffer;

    static DataLoader dataLoader;

    @BeforeAll
    public static void initAllParameters() {
        br = Mockito.mock(BufferedReader.class);
        dataBuffer = new DataBuffer(5);
        dataLoader = new DataLoader();
    }

    @Test
    public void shouldLoadDataSuccess() throws Exception {
        Mockito.when(br.readLine()).thenReturn("line1","line2","line3","end");
        dataLoader.loadData(br,dataBuffer);

        assertEquals(DataBufferStatus.EnqueueCompleted,dataBuffer.getStatus());
        assertEquals(3,dataBuffer.dequeue(3).size());
    }

    @Test
    public void shouldEndLoadSuccess( ) throws Exception {
        dataLoader.endLoad(br,dataBuffer);
        assertFalse(br.ready());
        assertEquals(DataBufferStatus.EnqueueCompleted,dataBuffer.getStatus());
    }

}
