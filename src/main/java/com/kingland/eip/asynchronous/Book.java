/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.asynchronous;

import static com.kingland.eip.asynchronous.Constants.*;
/**
 *  This class is try to define Book
 */
public class Book {
    private Long id;
    private String name;
    private double score;

    /**
     * builder constructor
     * @param builder
     */
    private Book(Book.Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.score = builder.score;
    }

    /**
     * This builder class is due to new object conveniently
     */
    static class Builder {
        private Long id;
        private String name;
        private Double score = DEFAULT_SCORE;

        public Builder id(Long id){
            if( id == null || id.toString().isEmpty()){
                throw new IllegalArgumentException("The id is empty");
            }
            this.id = id;
            return this;
        }

        public Builder name(String name){
            if (name == null || name.isEmpty()){
                throw new IllegalArgumentException("The name is empty");
            }
            this.name = name;
            return this;
        }

        public Builder score(Double score){
            if (score == null || score.toString().isEmpty()){
                throw new IllegalArgumentException("The score is empty");
            }
            this.score = score;
            return this;
        }

        /**
         * Check the data then create the new object
         * @return
         */
        public Book create(){
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
                throw new IllegalArgumentException("The name length should be 1-20");
            }
            if (score < LIMIT_MIN_SCORE || score > LIMIT_MAX_SCORE){
                throw new IllegalArgumentException("The score value should be 0.0-10.0");
            }
            return new Book(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}