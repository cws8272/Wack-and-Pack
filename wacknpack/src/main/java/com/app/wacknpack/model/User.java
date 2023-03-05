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
    @JsonProperty("firstname")
    private String fname;
    @JsonProperty("lastname")
    private String lname;

    public User (@JsonProperty("userId") int userId, @JsonProperty("email") String email,
                 @JsonProperty("password") String password, @JsonProperty("points") int points, @JsonProperty("firstname") String firstname, 
                 @JsonProperty("lastname") String lastname) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.points = points;
        this.fname = firstname;
        this.lname = lastname;
        }

    public int getUserId() {return this.userId;}

    public String getEmail() {return this.email;}

    public String getPassword() {return this.password;}

    public String getfirstname() {return this.fname;}

    public String getlastname() {return this.lname;}

    public int getPoints() {return this.points;}

    public int setPoints(int newPoints) {return this.points = newPoints;}
}
