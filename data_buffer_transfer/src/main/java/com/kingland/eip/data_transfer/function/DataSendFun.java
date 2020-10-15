/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer.function;

import java.util.List;

/**
 * this interface define a data send function
 * @param <T>
 */
public interface DataSendFun<T> {

    List<T> sendData(String path, int fileSize) throws Exception;
}