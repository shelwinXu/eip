/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.classes_interface;

/**
 * This main class can test two loggers
 */
public class Main {
    public static void main(String[] args) {
        final int fileLoggerMinLength = 10;
        final int fileLoggerMaxLength = 20;
        final int consoleLoggerMinLength = 5;
        final int consoleLoggerMaxLength = 10;
        final String testException = "java.lang.ArrayIndexOutOfBoundsException";
        final String testConsoleMessage = "message!";
        final String testFileMessage = "This is message!";

        ConsoleLogger consoleLogger = new ConsoleLogger.Builder()
                .minLength(consoleLoggerMinLength)
                .maxLength(consoleLoggerMaxLength)
                .create();

        consoleLogger.log(testException,testConsoleMessage);
        consoleLogger.log(testException);

        FileLogger fileLogger = new FileLogger.Builder()
                .minLength(fileLoggerMinLength)
                .maxLength(fileLoggerMaxLength)
                .create();

        fileLogger.log(testException,testFileMessage);
        fileLogger.log(testException);
    }
}