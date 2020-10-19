/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.kingland.eip.common.Consts.FILE_PATH_NUMBER;

public class ReadFileSource implements ReadSource{

    @Override
    public BufferedReader readSource(String ...path) {
        if (path.length != 1){
            throw new RuntimeException("The File source's path is not valid!");
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(path[FILE_PATH_NUMBER])));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }
}
