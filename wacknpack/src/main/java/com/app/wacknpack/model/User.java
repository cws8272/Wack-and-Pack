package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("points")
    private int points;

    public User (@JsonProperty("userId") int userId, @JsonProperty("email") String email,
                 @JsonProperty("password") String password, @JsonProperty("points") int points) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public int getUserId() {return this.userId;}

    public String getEmail() {return this.email;}

    public String getPassword() {return this.password;}

    public int getPoints() {return this.points;}

    public int setPoints(int newPoints) {return this.points = newPoints;}
}
