/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("test the employee is success")
public class EmployeeTest {
    static Bus testBus;

    @DisplayName("init bus before init employee")
    @BeforeAll
    public static void initBus(){
        testBus = new Bus("3 line");
        assertNotNull(testBus);
        assertEquals("3 line",testBus.getName());
    }

    @Test
    @DisplayName("test init employee is success")
    public void testEmployee(){
        Employee john = new Employee(testBus,"john");
        john.goToWork();
        assertNotNull(john);
        assertEquals("john",john.getName());
    }
}