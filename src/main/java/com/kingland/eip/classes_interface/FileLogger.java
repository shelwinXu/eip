/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.classes_interface;

import static com.kingland.eip.classes_interface.Constants.*;

/**
 * This class can print log information on console
 */
public class FileLogger implements CustomLogger{
    private int minLength;
    private int maxLength;

    /**
     * internal structure
     * @param builder
     */
    public FileLogger(FileLogger.Builder builder) {
        this.maxLength = builder.maxLength;
        this.minLength = builder.minLength;
    }

    /**
     * This Builer class can create Filelogger
     */
    public static class Builder {
        private int minLength;
        private int maxLength;

        public Builder minLength(int minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public FileLogger create() {
            if (maxLength < minLength){
                throw new RuntimeException("The Minimum and max length is not valid!");
            }
            return new FileLogger(this);
        }
    }

    /**
     * Print exception log
     * @param exception exception information
     */
    @Override
    public void log(String exception) {
        System.out.println(FILE_LOGGER_NAME + "--" + EXCEPTION_PREFIX + exception);
    }

    /**
     * Check the message log format
     * Print the message log first then print exception log
     * @param exception exception information
     * @param message message information
     */
    @Override
    public void log(String exception, String message) {
        if (message.length() >= minLength && message.length() <= maxLength) {
            System.out.println(FILE_LOGGER_NAME + "--" + message);
            log(exception);
        } else {
            throw new RuntimeException(FILE_LOGGER_NAME + "--" + EXCEPTION_PREFIX + "The message length is not valid!");
        }
    }
}
