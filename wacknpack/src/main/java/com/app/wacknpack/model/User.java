package com.app.wacknpack.model;

public class User {

    private final int id;
    private final String email;
    private final String password;
    private final Type userType;


    public User (int id, String email, String password, Type userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public enum Type {
        CUSTOMER, ORGANIZATION
    }
}
