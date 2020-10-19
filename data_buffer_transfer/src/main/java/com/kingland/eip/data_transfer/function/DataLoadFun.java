/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer.function;

import com.kingland.eip.common.buffer.DataBuffer;

import java.io.BufferedReader;
import java.util.List;

/**
 * this interface define a data load function
 * @param <T>
 */
public interface DataLoadFun<T> {

    void loadData(BufferedReader reader, DataBuffer<T> buffer) throws Exception;
}
