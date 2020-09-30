package com.kingland.eip.data_transfer.function;

import java.util.List;

/**
 * this interface define a data load function
 * @param <T>
 */
public interface DataLoadFun<T> {

    List<T> apply(int batchSize) throws Exception;
}
