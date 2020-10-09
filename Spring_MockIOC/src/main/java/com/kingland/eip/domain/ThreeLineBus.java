/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import static com.kingland.eip.common.Const.BUS_THREE;
/**
 * @author KSC
 */
public class ThreeLineBus implements IBus {

    @Override
    public void start() {
        System.out.println(BUS_THREE + " is start to driving!");
    }

    @Override
    public void turnLeft() {
        System.out.println(BUS_THREE + " is start to turn left!");
    }

    @Override
    public void turnRight() {
        System.out.println(BUS_THREE + " is start to turn right!");
    }

    @Override
    public void stop() {
        System.out.println(BUS_THREE + " is prepare to stop!");
    }
}
