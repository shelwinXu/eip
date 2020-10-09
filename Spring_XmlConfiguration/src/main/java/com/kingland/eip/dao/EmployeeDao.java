package com.kingland.eip.dao;

import com.kingland.eip.domain.Employee;

public class EmployeeDao {

    public void initEmployee(Employee employee){
        System.out.println("Init the employee");
    }

    public void finish(){
        System.out.println("EmployeeDao bean has bean init");
    }
}
