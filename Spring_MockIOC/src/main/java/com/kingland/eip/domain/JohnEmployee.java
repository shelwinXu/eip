/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import static com.kingland.eip.common.Const.EMPLOYEE_JOHN;
/**
 * @author KSC
 */
public class JohnEmployee implements IEmployee{

    private IBus iBus;

    public JohnEmployee(IBus iBus) {
        this.iBus = iBus;
    }

    @Override
    public void wakeUp() {
        System.out.println(EMPLOYEE_JOHN + " is wake up!");
    }

    @Override
    public void goToWork() {
        System.out.println(EMPLOYEE_JOHN + " is prepare to go to work!");
    }
}
