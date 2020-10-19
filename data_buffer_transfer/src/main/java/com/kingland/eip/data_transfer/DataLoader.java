/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.common.buffer.DataBuffer;
import com.kingland.eip.common.buffer.DataBufferStatus;
import com.kingland.eip.data_transfer.function.DataLoadFun;

import java.io.*;
import java.util.Collections;

import static com.kingland.eip.common.Consts.*;

/**
 * This class can load the data
 */
public class DataLoader<T> implements DataLoadFun {

    public void loadData(BufferedReader br, DataBuffer buffer) throws Exception {
        String str = null;
        do {
            str = br.readLine();
            if (str != null && buffer.getStatus() == DataBufferStatus.Active) {
                buffer.enqueue(Collections.singletonList((T) str));
            }
        } while (!END_STRING.equals(str));
    }
}