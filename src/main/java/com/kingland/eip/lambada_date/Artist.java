/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.lambada_date;

import static com.kingland.eip.lambada_date.Constants.*;

/**
 * This class define the Artist
 */
public class Artist {
    private String name;
    private int age;
    private Profession profession;

    /**
     * Artist Constructor
     * @param builder
     */
    private Artist(Artist.Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.profession = builder.profession;
    }

    /**
     * Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter profession
     * @return profession
     */
    public Profession getProfession() {
        return profession;
    }

    /**
     *  This class can Builder new Artist object
     */
    static class Builder{
        private String name;
        private int age;
        private Profession profession;

        public Builder name(String name){
            if (name == null || name.isEmpty()){
                throw new IllegalArgumentException("The name is empty");
            }
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder profession(Profession profession){
            this.profession =  profession;
            return this;
        }

        /**
         * check age and name first
         * then create new Artist object
         * @return Artist object
         */
        public Artist create(){
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
                throw new IllegalArgumentException("The name length should be 1-20");
            }
            if (age < LIMIT_MIN_AGE){
                throw new IllegalArgumentException("The age should be greater than 0");
            }
            return new Artist(this);
        }
    }

    /**
     * ToString method
     * @return
     */
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession=" + profession +
                '}';
    }
}

/**
 * Define Painter and Singer
 */
enum Profession{
    Painter,Singer
}