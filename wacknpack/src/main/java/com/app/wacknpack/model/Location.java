package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("locationId")
    private int locationId;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("longitude")
    private Long longitude;
    @JsonProperty("latitude")
    private Long latitude;
    @JsonProperty("donationType")
    private DonationAccepted donationType;

    public Location (@JsonProperty("locationId") int locationId, @JsonProperty("locationName") String locationName,
                     @JsonProperty("address") String address, @JsonProperty("longitude") Long longitude,
                     @JsonProperty("latitude") Long latitude, @JsonProperty("donationType") DonationAccepted donationType) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.donationType = donationType;
    }

    public enum DonationAccepted {
        APPLICANCES, BOOKS, CLOTHES, FOOD
    }

    public int getLocationId() {
        return this.locationId;
    }

    public String getlocationName() {
        return this.locationName;
    }

    public String getAddress() {
        return this.address;
    }

    public Long getLongitude() {
        return this.longitude;
    }

    public Long getLatitude() {
        return this.latitude;
    }

    public DonationAccepted getdonationType() {
        return this.donationType;
    }

}