/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.collections;

import java.util.ArrayList;

public class TestDemo extends ArrayList {
    private ArrayList<String> testStringList;

    public TestDemo(ArrayList<String> testStringList) {
        super();
        this.testStringList = testStringList;
    }

    public ArrayList<String> getTestStringList() {
        return testStringList;
    }

    public void setTestStringList(ArrayList<String> testStringList) {
        this.testStringList = testStringList;
    }
}
