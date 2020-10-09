/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.bean.ApplicationContext;
import com.kingland.eip.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
@DisplayName("Test the mock IOC is success")
public class MockIOCTest {
    static ApplicationContext applicationContext = new ApplicationContext();
    static String threeLineName = "3 line";
    static String tenLineName = "10 line";
    static String johnName = "john";
    static String maneName = "mane";

    @DisplayName("Init two Bus beans and two Employee beans")
    @BeforeAll
    public static void setBean(){
        applicationContext.setBean(threeLineName, ThreeLineBus.class);
        applicationContext.setBean(tenLineName, TenLineBus.class);
        applicationContext.setBean(johnName, JohnEmployee.class, threeLineName);
        applicationContext.setBean(maneName, ManeEmployee.class, tenLineName);
    }

    @DisplayName("Test john take 3 line bus to work")
    @Test
    public void testJohn(){
        IBus threeLine = (IBus) applicationContext.getBean(threeLineName);
        IEmployee john = (IEmployee) applicationContext.getBean(johnName);
        john.wakeUp();
        threeLine.start();
        threeLine.turnLeft();
        threeLine.turnRight();
        threeLine.stop();
        john.goToWork();
        assertNotNull(threeLine);
        assertNotNull(john);
    }

    @DisplayName("Test mane take 10 line bus to work")
    @Test
    public void testMane(){
        IBus tenLine = (IBus) applicationContext.getBean(tenLineName);
        IEmployee mane = (IEmployee) applicationContext.getBean(maneName);
        mane.wakeUp();
        tenLine.start();
        tenLine.turnLeft();
        tenLine.turnRight();
        tenLine.stop();
        mane.goToWork();
        assertNotNull(tenLine);
        assertNotNull(mane);
    }
}
