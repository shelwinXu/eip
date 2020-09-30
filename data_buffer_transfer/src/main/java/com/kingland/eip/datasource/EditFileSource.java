/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.kingland.eip.common.Consts.UTF_8;

public class EditFileSource {
    
    MultipleDataSources dataSources = new MultipleDataSources();
    public void sendData(String path, int fileSize) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            dataSources.createFileSource(path,fileSize);
        }
        FileInputStream fip = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fip, UTF_8);
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            // Convert to char and add to StringBuffer object
            sb.append((char) reader.read());
        }
        // Close the read stream
        reader.close();
        // Close the input stream and release system resources
        fip.close();
    }
}