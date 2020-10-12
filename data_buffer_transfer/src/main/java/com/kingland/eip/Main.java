/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.datasource.MultipleDataSources;

import java.util.Collections;
import java.util.List;

import static com.kingland.eip.data_transfer.DataSender.sendDataFun;

/**
 * this main can test the project
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //String filePath = "data_buffer_transfer/src/main/resources/Files/dataSource.txt";
        String designationPath = "data_buffer_transfer/src/main/resources/Files/designation.txt";
        int filesize = 1024;
        MultipleDataSources multipleDataSources = new MultipleDataSources();
        //multipleDataSources.createFileSource(filePath,filesize);

        //List consoleSource = multipleDataSources.createConsoleSource();
        List consoleSource = multipleDataSources.createNewConsoleSource();
        DataBuffer dataBuffer = new DataBuffer(10);
        //dataBuffer.enqueue(Collections.singletonList(consoleSource));
        dataBuffer.enqueue(consoleSource);
        dataBuffer.dequeue(10);
        //dataBuffer.enqueue(consoleSource);

        //sendDataFun(dataBuffer,designationPath);

    }
}