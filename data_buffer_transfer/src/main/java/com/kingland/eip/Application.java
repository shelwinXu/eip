/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.common.Consts;
import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.DataLoader;
import com.kingland.eip.data_transfer.DataSender;
import com.kingland.eip.datasource.MultipleDataSources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        final int capacity = 100;
        final int threads = 2;
        String sourcePath = null;
        List sourceList = new ArrayList<>();

        System.out.println("=====Data===Buffer===Transfer===System=====");
        System.out.println("===Please choose the transmission mode: ===");
        System.out.println("===1: file system    ===2: console transfer");
        Scanner scanner = new Scanner(System.in);
        int modeInt = scanner.nextInt();
        switch (modeInt) {
            case 1:
                sourcePath = "data_buffer_transfer/src/main/resources/Files/dataSource.txt";
                DataSender dataSender = new DataSender<>();
                sourceList = dataSender.sendData(sourcePath, 10);
                break;
            case 2:
                sourceList = new MultipleDataSources().createConsoleSource();
                break;
            default:
                throw new IllegalArgumentException("the mode you type is vaild!");
        }
        DataBuffer dataBuffer = new DataBuffer(capacity);

        int sourceSize = sourceList.size();
        // every threads run specific times which according to the source size
        final int times = sourceSize % capacity == 0 ? sourceSize / capacity : sourceSize / capacity + 1;

        List<Thread> threadList = new ArrayList<>(threads);
        List finalSourceList = sourceList;
        Thread producer = new Thread(() -> {
            try {
                for (int j = 0; j < times; ++j) {
                    dataBuffer.enqueue(finalSourceList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadList.add(producer);
        producer.start();

        DataLoader dataLoader = new DataLoader();
        // create consumer thread
        String finalSourcePath = Consts.FINAL_SOURCE_PATH;
        Thread consumer = new Thread(() -> {
            try {
                for (int j = 0; j < times; ++j) {
                    dataLoader.loadData(dataBuffer.dequeue(capacity), finalSourcePath);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadList.add(consumer);
        consumer.start();

        // wait all the threads finish
        for (Thread thread : threadList) {
            thread.join();
        }
    }
}