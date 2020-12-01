package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.DataLoader;
import com.kingland.eip.datasource.ReadConsoleSource;
import com.kingland.eip.datasource.ReadFileSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {
        final int threads = 2;
        final int capacity = 50;
        String sourcePath = null;
        DataBuffer dataBuffer = new DataBuffer(capacity);

        //1.choose the datasource: File or Console input
        // the file datasource is given
        // the console datasource need to input and end by "end" string

        /*sourcePath = "data_buffer_transfer/src/main/resources/Files/dataSource.txt";
        Stream<String> getFileStream = new ReadFileSource().readStream(sourcePath);
        DataLoader dataLoader = new DataLoader();

        dataLoader.loadSteam(getFileStream,dataBuffer);*/
        Stream<InputStreamReader> getConsoleStream = new ReadConsoleSource().readStream();


    }
}
