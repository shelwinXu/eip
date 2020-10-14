/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.data_transfer.function.DataSendFun;
import com.kingland.eip.datasource.MultipleDataSources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.kingland.eip.common.Consts.UTF_8;

public class DataSender<T> implements DataSendFun {
    MultipleDataSources dataSources = new MultipleDataSources();
    @Override
    public List<T> sendData(String path, int fileSize) throws IOException {
        List<T> dataList = new ArrayList<T>();
        File file = new File(path);
        if (!file.exists()){
            dataSources.createFileSource(path,fileSize);
        }
        FileInputStream fip = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fip, UTF_8);
        BufferedReader br = null;
        String str;
        br = new BufferedReader(reader);
        while ((str = br.readLine()) != null) {
            System.out.println(str);
            dataList.add((T) str);
        }
        // Close the read stream
        reader.close();
        // Close the input stream and release system resources
        fip.close();
        return dataList;
    }

}