/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

/**
 * This interface define four Bus method
 */
public interface IBus {
    /**
     * the bus start.
     */
    void start();
    /**
     * the bus turn left.
     */
    void turnLeft();
    /**
     * the bus turn right.
     */
    void turnRight();
    /**
     * the bus stop which means employee arrive the company.
     */
    void stop();
}
