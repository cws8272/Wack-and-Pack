package com.app.wacknpack.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("locationId")
    private String locationId;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("donationType")
    private DonationAccepted donationType;

    public Location (@JsonProperty("locationId") String locationId, @JsonProperty("locationName") String locationName,
                     @JsonProperty("address") String address, @JsonProperty("latitude") String latitude,
                     @JsonProperty("longitude") String longitude, @JsonProperty("donationType") DonationAccepted donationType) {
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

    public String getLocationId() {
        return this.locationId;
    }

    public String getlocationName() {
        return this.locationName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public DonationAccepted getdonationType() {
        return this.donationType;
    }

}