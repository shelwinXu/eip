/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.reflection;

import static com.kingland.eip.reflection.Constants.*;

/**
 * This class can print log information on console
 */
public class ConsoleLogger{
    private int minLength;
    private int maxLength;

    /**
     * internal structure
     * @param
     */
    private ConsoleLogger(int minLength,int maxLength) {
        if (maxLength < minLength){
            throw new IllegalArgumentException("The Minimum and max length is not valid!");
        }
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    private int getMinLength() {
        return minLength;
    }

    private void setMinLength(int minLength) {
        if (minLength < 0){
            throw new IllegalArgumentException("The minimum length should greater than zero");
        }
        this.minLength = minLength;
    }

    private int getMaxLength() {
        return maxLength;
    }

    private void setMaxLength(int maxLength) {
        if (maxLength < 0){
            throw new IllegalArgumentException("The minimum length should greater than zero");
        }
        this.maxLength = maxLength;
    }

    /**
     * Print exception log
     * @param exception exception information
     */
    private void log(String exception) {
        if (exception.startsWith(EXCEPTION_CHECK)){
            System.out.println(CONSOLE_LOGGER_NAME + "--" + exception);
        }else{
            throw new RuntimeException(CONSOLE_LOGGER_NAME + "This exception is not valid!");
        }
    }
    /**
     * Check the message log format
     * Print the message log first then print exception log
     * @param exception exception information
     * @param message message information
     */
    private void log(String exception, String message) {
        if (message.length() >= minLength && message.length() <= maxLength) {
            System.out.println(CONSOLE_LOGGER_NAME + "--" + message);
            log(exception);
        } else {
            throw new RuntimeException(CONSOLE_LOGGER_NAME + "--" + EXCEPTION_PREFIX + "The message length is not valid!");
        }
    }
}