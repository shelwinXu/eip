/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.*;
import java.util.Random;

import static com.kingland.eip.common.Consts.*;

/**
 * This class can create multiple data sources:
 *      1.Create a new file (if not exist) as a data source
 *      2.Use console to input data as a data source
 */
public class MultipleDataSources<T> implements DataSource<T>{
    @Override
    public void createFileSource(String path, int fileSize) throws IOException{
        File file = new File(path);
        if (file.exists()){

        }
        FileOutputStream fop = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fop, UTF_8);
        int leftLimit = LEFT_LIMIT;
        int rightLimit = RIGHT_LIMIT;
        int targetStringLength = fileSize * FILE_SIZE;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(targetStringLength);
        for (int i = 1; i <= targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            stringBuilder.append((char) randomLimitedInt);
            // 100 characters then to a new row
            if (i % ROW_CHARACTERS == 0){
                stringBuilder.append(NEWlINE);
            }
        }

        // Write to buffer
        writer.append(stringBuilder.toString());
        // Close the write stream and write the contents of the buffer to the file
        writer.close();
        fop.close();
    }


    public T createConsoleSource() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            sb.append(str);
            sb.append(NEWlINE);
        } while (!str.equals(END_STRING));
        return (T) sb;
    }
}