/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.function.DataLoadFun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import static com.kingland.eip.common.Consts.UTF_8;

/**
 * This class can send the data
 */
public class DataSender implements DataLoadFun {
    public static void sendDataFun(DataBuffer dataBuffer, String path) {
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, UTF_8);
            List dequeue = dataBuffer.dequeue(1);
            for (int i = 0; i < dequeue.size(); i++) {
                writer.append(dequeue.get(i).toString());
            }
            writer.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List apply(int batchSize) throws Exception {
        return null;
    }
}