package com.kingland.eip.collections;
/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
import java.util.ArrayList;

/**
 *  This main class is used to test ReadOnlyArrayList
 */
public class Main {
    public static void main(String[] args) {
        final String testString = "This is test string";
        final int testVarNumber = 2;

        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add("this");
        testArrayList.add("is");
        testArrayList.add("readOnly");

        ReadOnlyArrayList testArray = new ReadOnlyArrayList(testArrayList);
        testArray.add(testVarNumber,testString);
        testArray.set(testVarNumber,testString);
        testArray.remove(testVarNumber);
        testArray.addAll(testArrayList);
    }
}