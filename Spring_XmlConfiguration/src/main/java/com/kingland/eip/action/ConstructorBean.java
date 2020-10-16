/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import com.kingland.eip.dao.EmployeeDao;
import com.kingland.eip.domain.Employee;
/**
 * @author KSC
 */
public class ConstructorBean {
    private EmployeeDao employeeDao;
    private Employee employee;

    public ConstructorBean(EmployeeDao employeeDao, Employee employee) {
        this.employeeDao = employeeDao;
        this.employee = employee;
        System.out.println("Use constructor init EmployeeDao and Employee");
    }

    public void save(){
        employee.setName("Mane");
        employee.setAge("20");
        System.out.println(employee);
        employeeDao.initEmployee(employee);
    }
}
