/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.data_transfer;

import com.kingland.eip.data_transfer.function.DataLoadFun;
import com.kingland.eip.data_transfer.function.DataSendFun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import static com.kingland.eip.common.Consts.*;

/**
 * This class can load the data
 */
public class DataLoader<T> implements DataLoadFun {

    @Override
    public void loadData(List dataList, String path) {
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, UTF_8);
            for (int i = 0; i < dataList.size(); i++) {
                if (END_STRING.equals(dataList.get(i).toString())){
                    break;
                }
                writer.append(NEWlINE);
                writer.append(dataList.get(i).toString());
            }
            writer.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}