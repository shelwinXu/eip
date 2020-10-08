/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.bean.ApplicationContext;
import com.kingland.eip.domain.Bus;
import com.kingland.eip.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("test the mock IOC is success")
public class MockIOCTest {
    static ApplicationContext applicationContext = new ApplicationContext();
    static String threeLineName = "3 line";
    static String tenLineName = "10 line";
    static String johnName = "john";
    static String someOneName = "some one";

    @DisplayName("init two Bus beans and two Employee beans")
    @BeforeAll
    public static void setBean(){
        applicationContext.setBean(threeLineName, Bus.class);
        applicationContext.setBean(tenLineName, Bus.class);
        applicationContext.setBean(johnName, Employee.class, threeLineName);
        applicationContext.setBean(someOneName, Employee.class, tenLineName);
    }

    @DisplayName("test john take 3 line bus to work")
    @Test
    public void testJohn(){
        Bus threeLine = (Bus) applicationContext.getBean(threeLineName);
        assertNotNull(threeLine);
        threeLine.start();
        threeLine.turnLeft();
        threeLine.turnRight();
        threeLine.stop();
        Employee john = (Employee) applicationContext.getBean(johnName);
        john.goToWork();
        assertNotNull(john);
    }

    @DisplayName("test someone take 10 line bus to work")
    @Test
    public void testSomeone(){
        Bus tenLine = (Bus) applicationContext.getBean(tenLineName);
        assertNotNull(tenLine);
        tenLine.start();
        tenLine.turnLeft();
        tenLine.turnRight();
        tenLine.stop();
        Employee someOne = (Employee) applicationContext.getBean(someOneName);
        someOne.goToWork();
        assertNotNull(someOne);
    }
}
