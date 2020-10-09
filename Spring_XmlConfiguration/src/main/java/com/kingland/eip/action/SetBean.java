/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import com.kingland.eip.dao.EmployeeDao;
/**
 * @author KSC
 */
public class SetBean {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
        System.out.println("Use set method init EmployeeDao");
    }

    public void finish(){
        employeeDao.finish();
    }
}
