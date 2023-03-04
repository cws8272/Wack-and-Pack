package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rewards {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("points")
    private int points;

    public Rewards (@JsonProperty("userId") int userId, @JsonProperty("points") int points) {
        this.userId = userId;
        this.points = points;
    }

    public int getUserId() {return this.userId;}

    public int getPoints() {return this.points;}

    public int setPoints(int newPoints) {return this.points = newPoints;}
    
}