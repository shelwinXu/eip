package com.kingland.eip.asynchronous.model;

public class User {
    private long id;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }
}
