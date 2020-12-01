/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.common.buffer.DataBufferStatus;
import com.kingland.eip.data_transfer.function.DataLoadFun;

import java.io.*;
import java.util.Collections;
import java.util.stream.Stream;

import static com.kingland.eip.common.Consts.*;

/**
 * This class can load the data
 */
public class DataLoader<T> implements DataLoadFun {
    @Override
    public void loadData(BufferedReader br, DataBuffer dataBuffer) throws Exception {
        String str = null;
        while ((str = br.readLine()) != null) {
            if (CONSOLE_END_STRING.equals(str)) {
                endLoad(br, dataBuffer);
                return;
            }

            if (dataBuffer.getStatus() == DataBufferStatus.Active) {
                dataBuffer.enqueue(Collections.singletonList((T) str));
            }
        }
        endLoad(br, dataBuffer);
    }

    public void loadSteam(Stream<String> lines, DataBuffer dataBuffer) throws Exception {
        /*String str = null;
        while ((str = br.readLine()) != null) {
            if (CONSOLE_END_STRING.equals(str)) {
                endLoad(br, dataBuffer);
                return;
            }

            if (dataBuffer.getStatus() == DataBufferStatus.Active) {
                dataBuffer.enqueue(Collections.singletonList((T) str));
            }
        }*/
        //endLoad(br, dataBuffer);
        lines.filter(line -> !line.equals(CONSOLE_END_STRING))
                .forEach(System.out::println);
    }

    public void endLoad(BufferedReader br, DataBuffer dataBuffer) throws Exception {
        dataBuffer.setStatus(DataBufferStatus.EnqueueCompleted);
        br.close();
    }
}
