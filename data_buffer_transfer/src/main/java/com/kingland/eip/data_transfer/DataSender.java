/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.common.buffer.DataBufferStatus;
import com.kingland.eip.data_transfer.function.DataSendFun;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.kingland.eip.common.Consts.*;

public class DataSender<T> implements DataSendFun {
    @Override
    public void sendData(DataBuffer dataBuffer, int count, String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        boolean completed = false;
        do {
            List<T> dataList = dataBuffer.dequeue(count);
            if (dataList.size() > 0){
                saveData(file,dataList);
            }else {
                if (dataBuffer.getStatus() != DataBufferStatus.Active){
                    completed = true;
                }else {
                    System.out.println("No data can be dequeued from the active buffer, try again...");
                }
            }
        } while (!completed);
        dataBuffer.setStatus(DataBufferStatus.DequeueCompleted);
    }

    public void saveData(File file, List<T> dataList){
        try (FileOutputStream outputStream = new FileOutputStream(file, true);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            for (Object obj : dataList) {
                writer.append(NEWlINE);
                writer.append(obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}