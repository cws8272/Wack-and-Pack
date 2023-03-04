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
    private Double longitude;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("donationType")
    private DonationAccepted donationType;


    public Location (@JsonProperty("locationId") int locationId, @JsonProperty("locationName") String locationName,
                     @JsonProperty("address") String address, @JsonProperty("longitude") Double longitude,
                     @JsonProperty("latitude") Double latitude, @JsonProperty("donationType") DonationAccepted donationType) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.donationType = donationType;
    }

    public enum DonationAccepted {
        APPLICANCES("appliances"), BOOKS("library"), CLOTHES("clothes"), FOOD("food");
        DonationAccepted(String value) {
        }
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

    public Double getLongitude() {
        return this.longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public DonationAccepted getdonationType() {
        return this.donationType;
    }

}