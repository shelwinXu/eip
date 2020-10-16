/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.dao;

import com.kingland.eip.domain.Employee;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author KSC
 */
@Component
@Lazy
public class EmployeeDao {

    public void initEmployee(Employee employee){
        System.out.println("Init the employee");
    }

    public void finish(){
        System.out.println("EmployeeDao bean has bean init");
    }
}
