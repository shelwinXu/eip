/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.DataLoader;
import com.kingland.eip.data_transfer.DataSender;
import com.kingland.eip.datasource.ReadConsoleSource;
import com.kingland.eip.datasource.ReadFileSource;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.kingland.eip.common.Consts.FINAL_SOURCE_PATH;

public class Application {
    public static void main(String[] args) throws Exception {
        final int threads = 2;
        final int capacity = 50;
        String sourcePath = null;
        DataBuffer dataBuffer = new DataBuffer(capacity);
        BufferedReader br;
        //1.choose the datasource
        //  the file datasource is given
        System.out.println("=====Data===Buffer===Transfer===System=====");
        System.out.println("===Please choose the transmission mode: ===");
        System.out.println("===1: file system    ===2: console transfer");
        Scanner scanner = new Scanner(System.in);
        int modeInt = scanner.nextInt();
        switch (modeInt) {
            case 1:
                sourcePath = "data_buffer_transfer/src/main/resources/Files/dataSource.txt";
                br = new ReadFileSource().readSource(sourcePath);
                break;
            case 2:
                br = new ReadConsoleSource().readSource();
                break;
            default:
                throw new IllegalArgumentException("the mode you type is vaild!");
        }

        //2.load data into buffer
        DataLoader dataLoader = new DataLoader();
        List<Thread> threadList = new ArrayList<>(threads);

        int loadTimes = 3;
        Thread producer = new Thread(() -> {
            try {
                for (int j = 0; j < loadTimes; ++j) {
                    dataLoader.loadData(br,dataBuffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadList.add(producer);
        producer.start();

        //3.send data to destination
        DataSender dataSender = new DataSender();
        int sendTimes = 11;
        int count = 10;
        Thread consumer = new Thread(() -> {
            try {
                for (int j = 0; j < sendTimes; ++j) {
                    dataSender.sendData(dataBuffer, count, FINAL_SOURCE_PATH);
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
