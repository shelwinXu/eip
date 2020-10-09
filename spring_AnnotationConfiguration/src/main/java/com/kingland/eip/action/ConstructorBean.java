/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import com.kingland.eip.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author KSC
 */
@Component
@Scope
@Lazy
public class ConstructorBean {

    private Employee employee;

    @Autowired
    public ConstructorBean( Employee employee) {
        this.employee = employee;
        System.out.println("Use constructor init Employee");
    }

}
