/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.datasource.MultipleDataSources;

import java.util.Collections;

import static com.kingland.eip.data_transfer.DataSender.sendDataFun;

/**
 * this main can test the project
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/Files/dataSource.txt";
        String designationPath = "src/main/resources/Files/designation.txt";
        int filesize = 1024;
        MultipleDataSources multipleDataSources = new MultipleDataSources();
        multipleDataSources.createFileSource(filePath,filesize);

        Object consoleSource = multipleDataSources.createConsoleSource();
        DataBuffer dataBuffer = new DataBuffer(10);
        dataBuffer.enqueue(Collections.singletonList(consoleSource));
        sendDataFun(dataBuffer,designationPath);
    }
}