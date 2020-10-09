/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import static com.kingland.eip.common.Const.BUS_TEN;
/**
 * @author KSC
 */
public class TenLineBus implements IBus{

    @Override
    public void start() {
        System.out.println(BUS_TEN + " is start to driving!");
    }

    @Override
    public void turnLeft() {
        System.out.println(BUS_TEN + " is start to turn left!");
    }

    @Override
    public void turnRight() {
        System.out.println(BUS_TEN + " is start to turn right!");
    }

    @Override
    public void stop() {
        System.out.println(BUS_TEN + " is prepare to stop!");
    }
}
