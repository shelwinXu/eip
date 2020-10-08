/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("test bus class")
public class BusTest {
    @Test
    @DisplayName("test init bus is success")
    public void testBus(){
        Bus threeLine = new Bus("3 line");
        assertNotNull(threeLine);
        assertEquals("3 line",threeLine.getName());
        threeLine.start();
        threeLine.turnLeft();
        threeLine.turnRight();
        threeLine.stop();
    }
}
