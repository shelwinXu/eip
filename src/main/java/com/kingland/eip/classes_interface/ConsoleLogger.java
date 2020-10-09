/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.classes_interface;

import static com.kingland.eip.classes_interface.Constants.CONSOLE_LOGGER_NAME;
import static com.kingland.eip.classes_interface.Constants.EXCEPTION_PREFIX;

/**
 * This class can print log information on console
 */
public class ConsoleLogger extends AbstractLogger {
    @Override
    protected void doLog(String log) {
        System.out.println(CONSOLE_LOGGER_NAME + log);
    }

    /**
     * internal structure
     *
     * @param builder
     */
    public ConsoleLogger(Builder builder) {
        this.setMaxLength(builder.maxLength);
        this.setMinLength(builder.minLength);
    }

    /**
     * This Builer class can create Consolelogger
     */
    public static class Builder {
        private int minLength;
        private int maxLength;

        public Builder minLength(int minLength) {
            if (minLength < 0) {
                throw new IllegalArgumentException("Minimum length is not valid!");
            }
            this.minLength = minLength;
            return this;
        }

        public Builder maxLength(int maxLength) {
            if (maxLength < 0) {
                throw new IllegalArgumentException("Max length is not valid!");
            }
            this.maxLength = maxLength;
            return this;
        }

        public ConsoleLogger create() {
            if (maxLength < minLength) {
                throw new RuntimeException("The Minimum and max length is not valid!");
            }
            return new ConsoleLogger(this);
        }
    }
}