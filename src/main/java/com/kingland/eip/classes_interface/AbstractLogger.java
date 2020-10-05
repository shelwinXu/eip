/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.classes_interface;

import static com.kingland.eip.classes_interface.Constants.EXCEPTION_PREFIX;

/**
 * This abstract class define some methods that ConsoleLogger and ConsoleLogger both use
 */
public abstract class AbstractLogger implements CustomLogger {
    private int minLength;

    private int maxLength;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    protected abstract void doLog(String log);

    /**
     * Print the exception log
     *
     * @param exception
     */
    @Override
    public void log(String exception) {
        if (this.vaildExceptionFormat(exception)) {
            this.doLog(exception);
        } else {
            throw new IllegalArgumentException("The Exception is not valid");
        }
    }

    /**
     * Print the message log first then print exception log
     *
     * @param exception exception information
     * @param message   message information
     */
    @Override
    public void log(String exception, String message) {
        this.log(exception);
        if (this.vaildMessageFormat(message)) {
            this.doLog(message);
        } else {
            throw new IllegalArgumentException("The Message is not valid");
        }
    }

    /**
     * Check the exception log format
     *
     * @param exception exception information
     * @return true: valid; false: not valid
     */
    private boolean vaildExceptionFormat(String exception) {
        if (exception == null || exception.isEmpty()) {
            return false;
        }

        if (exception.startsWith(EXCEPTION_PREFIX)) {
            return true;
        }
        return false;
    }

    /**
     * Check the message log format
     *
     * @param message message information
     * @return true: valid; false: not valid
     */
    private boolean vaildMessageFormat(String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }

        if (message.length() > minLength && message.length() < maxLength) {
            return true;
        }

        return false;
    }
}