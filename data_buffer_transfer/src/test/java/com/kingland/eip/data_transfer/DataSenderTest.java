/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.common.buffer.DataBufferStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSenderTest {
    static DataBuffer dataBuffer;

    static List dataList;

    static DataSender dataSender;

    static String filePath;

    static long preFileSize;

    @BeforeAll
    static void beforeAll() {
        filePath = "src/main/resources/Files/test.txt";
        dataList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            dataList.add("test string");
        }
        dataSender = new DataSender();
    }

    @Test
    public void shouldSendDataSuccess() throws Exception {
        int capacity = 5;
        dataBuffer = new DataBuffer(capacity);
        dataBuffer.enqueue(dataList);

        dataSender.sendData(dataBuffer, 5, filePath);

        assertEquals(DataBufferStatus.DequeueCompleted, dataBuffer.getStatus());
    }

    @Test
    public void shouldSaveData() {
        File file = new File(filePath);
        preFileSize = file.length();

        dataSender.saveData(file, dataList);

        assertEquals(48, file.length() - preFileSize);
    }
}
