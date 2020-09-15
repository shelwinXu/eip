/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.javaFundamental;

/**
 * This class can create different class
 */
public class BuilderLogger {
    public static final String EXCEPTION_PREFIX = "EXCEPTION:";
    private String loggerName;
    private int minLength;
    private int maxLength;

    /**
     * internal structure
     * @param builder
     */
    public BuilderLogger(Builder builder) {
        this.maxLength = builder.maxLength;
        this.minLength = builder.minLength;
        this.loggerName = builder.loggerName;
    }

    /**
     * This Builer class can create different logger
     */
    public static class Builder {
        private int minLength;
        private int maxLength;
        private String loggerName;

        public Builder loggerName(String loggerName) {
            this.loggerName = loggerName;
            return this;
        }

        public Builder minLength(int minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder maxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public BuilderLogger create() {
            return new BuilderLogger(this);
        }
    }

    /**
     * Print the exception log
     * @param exception
     */
    public void log(String exception) {
        System.out.println(loggerName + "--" + EXCEPTION_PREFIX + exception);
    }

    /**
     * Check the message log format
     * Print the exception log and message log
     * @param exception
     * @param message
     */
    public void log(String exception, String message) {
        if (message.length() >= minLength && message.length() <= maxLength) {
            System.out.println(loggerName + "--" + message + "," + EXCEPTION_PREFIX + exception);
        } else {
            throw new RuntimeException(loggerName + "--" + EXCEPTION_PREFIX + "The message length is not valid!");
        }
    }
}
