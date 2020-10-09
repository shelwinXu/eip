/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import static com.kingland.eip.common.Const.EMPLOYEE_MANE;
/**
 * @author KSC
 */
public class ManeEmployee implements IEmployee{

    private IBus iBus;

    public ManeEmployee(IBus iBus) {
        this.iBus = iBus;
    }

    @Override
    public void wakeUp() {
        System.out.println(EMPLOYEE_MANE + " is wake up!");
    }

    @Override
    public void goToWork() {
        System.out.println(EMPLOYEE_MANE + " is prepare to go to work!");
    }
}
