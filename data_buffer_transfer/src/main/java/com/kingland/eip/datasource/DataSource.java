/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.datasource;

import java.io.IOException;

public interface DataSource<T> {

    void createFileSource(String path,int fileSize) throws IOException;

    T createConsoleSource() throws IOException;
}
