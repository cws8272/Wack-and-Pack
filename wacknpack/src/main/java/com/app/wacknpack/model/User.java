package com.app.wacknpack.model;

public class User {
    @JsonProperty("userId")
    private final int userId;

    @JsonProperty("email")
    private final String email;

    @JsonProperty("password")
    private final String password;

    @JsonProperty("userType")
    private final Type userType;


    public User (@JsonProperty("userId") int userId, @JsonProperty("email") String email,
                 @JsonProperty("password") String password, @JsonProperty("userType") Type userType) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public enum Type {
        CUSTOMER, ORGANIZATION
    }
}
