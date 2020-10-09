package com.kingland.eip.collections;
/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This main class is used to test ReadOnlyArrayList
 */
public class Main {
    public static void main(String[] args) {
        final String testString1 = "first test string";
        final String testString2 = "second test string";
        final String testString3 = "third test string";
        final String testSetString = "set test string";
        final String testAddString = "add test string";
        final int testVarNumber = 1;

        ArrayList<String> testArrayList = new ArrayList<>();
        testArrayList.add(testString1);
        testArrayList.add(testString2);
        testArrayList.add(testString3);

        ReadOnlyArrayList testArray = new ReadOnlyArrayList(testArrayList);
        try {
            testArray.add(testAddString);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        try {
            testArray.set(testVarNumber, testSetString);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        try {
            testArray.remove(testVarNumber);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        try {
            testArray.addAll(testArrayList);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        Iterator testIterator = testArray.iterator();
        while (testIterator.hasNext()) {
            Object next = testIterator.next();
            if (testString3.equals(next.toString())) {
                testIterator.remove();
            }
            System.out.println(next);
        }
    }
}