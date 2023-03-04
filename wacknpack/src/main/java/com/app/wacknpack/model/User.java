package com.app.wacknpack.model;

public class User {
    @JsonProperty("user_id")
    private final int user_id;

    @JsonProperty("email")
    private final String email;

    @JsonProperty("password")
    private final String password;

    @JsonProperty("user_type")
    private final Type user_type;


    public User (@JsonProperty("uesr_id") int user_id, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("user_type") Type user_type) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.user_type = user_type;
    }

    public enum Type {
        CUSTOMER, ORGANIZATION
    }
}
