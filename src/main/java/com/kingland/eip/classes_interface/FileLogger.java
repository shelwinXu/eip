/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.classes_interface;

import static com.kingland.eip.classes_interface.Constants.*;

/**
 * This class can print log information on console
 */
public class FileLogger extends AbstractLogger {
    @Override
    protected void doLog(String log) {
        System.out.println(FILE_LOGGER_NAME + log);
    }

    /**
     * internal structure
     *
     * @param builder
     */
    public FileLogger(FileLogger.Builder builder) {
        this.setMaxLength(builder.maxLength);
        this.setMinLength(builder.minLength);
    }

    /**
     * This Builer class can create Filelogger
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

        public FileLogger create() {
            if (maxLength < minLength) {
                throw new RuntimeException("The Minimum and max length is not valid!");
            }
            return new FileLogger(this);
        }
    }
}
