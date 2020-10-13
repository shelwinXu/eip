package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.DataSender;
import com.kingland.eip.datasource.MultipleDataSources;

import java.util.ArrayList;
import java.util.List;

public class NewMain {
    public static void main(String[] args) throws Exception{

        String designationPath = "data_buffer_transfer/src/main/resources/Files/designation.txt";
        DataSender dataSender = new DataSender();
        List consoleSource = new MultipleDataSources().createNewConsoleSource();
        int consoleSize = consoleSource.size();
        int capacity = 10;
        DataBuffer dataBuffer = new DataBuffer(capacity);


        final int threads = 2;
        // 每个线程执行10次
        final int times = consoleSize % capacity == 0 ? consoleSize / capacity : consoleSize / capacity + 1;

        List<Thread> threadList = new ArrayList<>(threads);
        //for (int i = 0; i < threads; ++i) {
        //    final int offset = i * times;
            Thread producer = new Thread(() -> {
                try {
                    int count = 0;
                    for (int j = 0; j < times; ++j) {
                        //count++;
                        //System.out.println(count);
                        //if (count == consoleSize){
                        //    break;
                        //}
                        dataBuffer.enqueue(consoleSource);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            threadList.add(producer);
            producer.start();
        //}

        // 创建2个消费者线程，从队列中弹出20次数字并打印弹出的数字
        //for (int i = 0; i < threads; ++i) {
            Thread consumer = new Thread(() -> {
                try {
                    for (int j = 0; j < times; ++j) {
                        List list = dataBuffer.dequeue(10);
                        dataSender.sendData(list,designationPath);
                        System.out.println(list);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            threadList.add(consumer);
            consumer.start();
        //}

        // 等待所有线程执行完成
        for (Thread thread : threadList) {
            thread.join();
        }

    }

}
