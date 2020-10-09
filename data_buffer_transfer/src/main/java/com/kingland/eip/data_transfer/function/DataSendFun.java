package com.kingland.eip.data_transfer.function;

import java.util.List;

/**
 * this interface define a data send function
 * @param <T>
 */
public interface DataSendFun<T> {

    void execute(List<T> datalist) throws Exception;
}