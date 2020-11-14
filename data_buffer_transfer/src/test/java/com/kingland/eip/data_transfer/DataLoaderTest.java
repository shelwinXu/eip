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
        //init BufferedReader、DataBuffer、DataLoader
        br = Mockito.mock(BufferedReader.class);
        dataBuffer = new DataBuffer(5);
        dataLoader = new DataLoader();
    }

    @Test
    public void shouldLoadDataSuccess() throws Exception {
        //given analog data
        Mockito.when(br.readLine()).thenReturn("line1","line2","line3","end");

        //when load the data in the br(BufferedReader)
        dataLoader.loadData(br,dataBuffer);

        //then dataBuffer have the data and DataBufferStatus is EnqueueCompleted
        assertEquals(DataBufferStatus.EnqueueCompleted,dataBuffer.getStatus());
        assertEquals(3,dataBuffer.dequeue(3).size());
    }

    @Test
    public void shouldEndLoadSuccess( ) throws Exception {
        //when endLoad the data
        dataLoader.endLoad(br,dataBuffer);

        //then the br(BufferedReader) close and DataBufferStatus is EnqueueCompleted
        assertFalse(br.ready());
        assertEquals(DataBufferStatus.EnqueueCompleted,dataBuffer.getStatus());
    }

}
