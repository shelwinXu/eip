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
        //init filepath、dataList、DataSender
        filePath = "src/main/resources/Files/test.txt";
        dataList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            dataList.add("test string");
        }
        dataSender = new DataSender();
    }

    @Test
    public void shouldSendDataSuccess() throws Exception {
        //given DataBuffer and add data in the DataBuffer
        int capacity = 5;
        dataBuffer = new DataBuffer(capacity);
        dataBuffer.enqueue(dataList);

        //when dataSender send data
        dataSender.sendData(dataBuffer, 5, filePath);

        //then DataBufferStatus is DequeueCompleted
        assertEquals(DataBufferStatus.DequeueCompleted, dataBuffer.getStatus());
    }

    @Test
    public void shouldSaveData() {
        //given the file path
        File file = new File(filePath);
        preFileSize = file.length();

        //when dataSender save the data
        dataSender.saveData(file, dataList);

        //then the data save in the file
        assertEquals(48, file.length() - preFileSize);
    }
}
