package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rewards {
    @JsonProperty("userId")
    private final int userId;
    @JsonProperty("points")
    private final int points;

    public Rewards (@JsonProperty("userId") int userId, @JsonProperty("points") int points) {
        this.userId = userId;
        this.points = points;
    }

    public int getUserId() {return userId;}

    public int getPoints() {return points;}
}