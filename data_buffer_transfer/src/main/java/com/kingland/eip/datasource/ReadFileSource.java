/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import com.kingland.eip.common.Consts;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.kingland.eip.common.Consts.FILE_PATH_NUMBER;

public class ReadFileSource implements ReadSource{

    @Override
    public BufferedReader readSource(String ...path) {
        if (path.length != Consts.FILE_PATH_NUMBER_REQUIRE){
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

    public Stream<String> readStream(String ...path){
        if (path.length != Consts.FILE_PATH_NUMBER_REQUIRE){
            throw new RuntimeException("The File source's path is not valid!");
        }

        try {
            Stream<String> lines = Files.lines(Paths.get(path[0]));
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Stream.empty();
    }
}
