/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

import static com.kingland.eip.common.Consts.*;
import static com.kingland.eip.common.Consts.NEWlINE;
import static java.nio.charset.StandardCharsets.UTF_8;

public class CreateTestFile {
    public static void main(String[] args) throws IOException {
        int fileSize = 10;
        String sourcePath = "data_buffer_transfer/src/main/resources/Files/dataSource.txt";
        File file = new File(sourcePath);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
        try (FileOutputStream fop = new FileOutputStream(file);
             OutputStreamWriter writer = new OutputStreamWriter(fop, UTF_8)) {
            int targetStringLength = fileSize * FILE_SIZE;
            Random random = new Random();
            StringBuilder stringBuilder = new StringBuilder(targetStringLength);
            for (int i = 1; i <= targetStringLength; i++) {
                int randomLimitedInt = LEFT_LIMIT + (int)
                        (random.nextFloat() * (RIGHT_LIMIT - LEFT_LIMIT + 1));
                stringBuilder.append((char) randomLimitedInt);
                // 100 characters then to a new row
                if (i % ROW_CHARACTERS == 0) {
                    stringBuilder.append(NEWlINE);
                }
            }
            // Write to buffer
            writer.append(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
