/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

/**
 * define a bus entity class
 */
public class Bus {
    private String name;

    public Bus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void start(){
        System.out.println(name + " bus is start to driving!");
    }

    public void turnLeft(){
        System.out.println(name + " bus is start to turn left!");
    }

    public void turnRight(){
        System.out.println(name + " bus is start to turn right!");
    }

    public void stop(){
        System.out.println(name + " bus is prepared to stop!");
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                '}';
    }
}