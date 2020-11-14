/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.BufferedReader;

public interface ReadSource {

    BufferedReader readSource(String ...path);
}
