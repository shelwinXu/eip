/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.BufferedReader;
import java.util.stream.Stream;

public interface ReadSource {

    BufferedReader readSource(String ...path);

    //Stream<String> readStream(String ...path);
}
