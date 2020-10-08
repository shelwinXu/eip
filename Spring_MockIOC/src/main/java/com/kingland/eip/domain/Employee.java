/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

/**
 * define a employee entity class
 */
public class Employee {

    private String name;
    private Bus bus;

    public Employee(Bus bus,String name) {
        this.bus = bus;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goToWork(){
        System.out.printf("%s take %s is prepared go to work!", name, bus.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", bus=" + bus +
                '}';
    }
}