package com.kingland.eip.action;

import com.kingland.eip.dao.EmployeeDao;

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
