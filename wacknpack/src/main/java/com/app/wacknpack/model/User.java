package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("userId")
    private final int userId;
    @JsonProperty("email")
    private final String email;
    @JsonProperty("password")
    private final String password;
    @JsonProperty("userType")
    private final UserType userType;

    public User (@JsonProperty("userId") int userId, @JsonProperty("email") String email,
                 @JsonProperty("password") String password, @JsonProperty("userType") Type userType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public enum UserType {
        CUSTOMER, ORGANIZATION
    }

    public int getUserId() {return this.userId;}

    public String getEmail() {return this.email;}

    public String getPassword() {return this.password;}

    public UserType getUserType() {return this.userType;}
}
