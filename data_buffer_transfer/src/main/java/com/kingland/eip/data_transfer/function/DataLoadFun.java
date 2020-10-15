/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer.function;

import java.util.List;

/**
 * this interface define a data load function
 * @param <T>
 */
public interface DataLoadFun<T> {

    void loadData(List<T> dataList, String path);
}
