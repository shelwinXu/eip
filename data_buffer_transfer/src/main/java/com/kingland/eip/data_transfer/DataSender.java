/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.data_transfer.function.DataSendFun;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.kingland.eip.common.Consts.END_STRING;
import static com.kingland.eip.common.Consts.NEWlINE;

public class DataSender<T> implements DataSendFun {
    @Override
    public void sendData(DataBuffer dataBuffer, int count, String path) throws Exception {
        List<T> dataList = dataBuffer.dequeue(count);
        File file = new File(path);
        try (FileOutputStream outputStream = new FileOutputStream(file, true);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            for (Object obj : dataList) {
                if (END_STRING.equals(obj.toString())) {
                    break;
                }
                writer.append(NEWlINE);
                writer.append(obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}