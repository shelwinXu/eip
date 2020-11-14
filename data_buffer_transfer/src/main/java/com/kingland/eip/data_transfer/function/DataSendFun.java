/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer.function;

import com.kingland.eip.common.buffer.DataBuffer;

import java.util.List;

/**
 * this interface define a data send function
 * @param <T>
 */
public interface DataSendFun<T> {

    void sendData(DataBuffer<T> dataBuffer, int count, String path) throws Exception;
}