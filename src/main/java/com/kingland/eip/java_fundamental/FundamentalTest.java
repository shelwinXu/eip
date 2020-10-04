/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.java_fundamental;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *  This main function can solve four issues
 *  1.print hello world
 *  2.print pattern and current date&time
 *  3.print month abbreviation
 *  4.print and check Good morning string
 */
public class FundamentalTest {
    /**
     * The init month
     */
    public static final int INIT_MONTH = 10;

    /**
     * The check character of string start
     */
    public static final String START_CHARACTER = "G";

    /**
     * The check character and string split condition
     */
    public static final String SPACE_CHARACTER = " ";

    public static void main(String[] args) {

        //1.print hello world
        System.out.println("hello world");

        //2.print pattern and current date&time
        //print pattern
        int patternRows = 10;
        final String patternShape = "*";
        for (int i = 0; i < patternRows; i++) {
            for (int j = patternRows - i; j > 0 ; j--) {
                System.out.print(patternShape);
            }
            System.out.println();
        }
        //print date & time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("current date and time: " + currentDate +" "+ currentTime);

        //3.print month abbreviation
        printSpecifyMonth(INIT_MONTH);

        //4.print and check Good morning string
        String testStr = "Good morning";
        int checkStrLength = checkStringValue(testStr);
        if (checkStrLength != -1){
            if (checkStrLength % 2 == 0){
                System.out.printf("The length of this string is %d", checkStrLength);
            }else {
                System.out.println("The length of this string is odd number");
            }
        }else {
            System.out.println("This string is empty!");
        }
    }

    /**
     * This method can print specify month abbreviation
     * @param monthNumber
     */
    public static void printSpecifyMonth(int monthNumber){
        switch(monthNumber){
            case 1:
                System.out.println("Jan");
                break;
            case 2:
                System.out.println("Feb");
                break;
            case 3:
                System.out.println("Mar");
                break;
            case 4:
                System.out.println("Apr");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("Jun");
                break;
            case 7:
                System.out.println("Jul");
                break;
            case 8:
                System.out.println("Aug");
                break;
            case 9:
                System.out.println("Sep");
                break;
            case 10:
                System.out.println("Oct");
                break;
            case 11:
                System.out.println("Nov");
                break;
            case 12:
                System.out.println("Dec");
                break;
            default:
                System.out.println("Unexpected value: " + monthNumber);
        }
    }

    /**
     * This method can check the input string
     * @param testStr
     * @return
     */
    public static int checkStringValue(String testStr){
        if (null == testStr || testStr.isEmpty()) {
            System.out.println("The test string is empty");
            return -1;
        }

        if (testStr.startsWith(START_CHARACTER) && testStr.contains(SPACE_CHARACTER)){
            String[] split = testStr.split(SPACE_CHARACTER);
            for (String subStr : split) {
                System.out.println(subStr);
            }
        }
        return testStr.length();
    }
}