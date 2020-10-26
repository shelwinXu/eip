/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

public class DataSenderTest {
    static BufferedReader br;

    static DataBuffer dataBuffer;

    static DataLoader dataLoader;
    @BeforeAll
    public static void initAllParameters() throws IOException {
        br = Mockito.mock(BufferedReader.class);
        Mockito.when(br.readLine()).thenReturn("line1","line2","line3","end");
        dataBuffer = new DataBuffer(5);
        dataLoader = new DataLoader();
    }
}
