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

    public Integer getUserId() {return this.userId;}

    public Integer getPoints() {return this.points;}

    public Integer setPoints(int newPoints) {return this.points = newPoints;}
    
}