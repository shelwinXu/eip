/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * This class try to use reflection to new ConsoleLogger
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        final String testException = "Exception:java.lang.ArrayIndexOutOfBoundsException";
        final String testConsoleMessage = "message test!";
        String className = "com.kingland.eip.reflection.ConsoleLogger";
        int minLength = 10;
        int maxLength = 20;

        Class<?> loggerClass = Class.forName(className);
        Constructor<?> declaredConstructor = loggerClass.getDeclaredConstructor(int.class,int.class);
        declaredConstructor.setAccessible(true);

        ConsoleLogger consoleLogger  = (ConsoleLogger)declaredConstructor.newInstance(minLength, maxLength);
        Method logException = loggerClass.getDeclaredMethod("log", String.class);
        Method logExceptionMessage = loggerClass.getDeclaredMethod("log", String.class, String.class);
        logException.setAccessible(true);
        logExceptionMessage.setAccessible(true);
        logException.invoke(consoleLogger,testException);
        logExceptionMessage.invoke(consoleLogger,testException,testConsoleMessage);
    }
}