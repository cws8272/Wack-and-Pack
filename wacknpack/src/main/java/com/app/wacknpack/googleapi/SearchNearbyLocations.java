package com.app.wacknpack.googleapi;

import com.app.wacknpack.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Slf4j
public class SearchNearbyLocations {
    private static final String API_KEY = "AIzaSyDwr8N8aIYOGb4myt5xV9bz9DlQPN8aFJU";
    private static final String SEARCH_REQUEST_URI = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
    private static final HttpClient client = HttpClient.newBuilder().build();
    private static final String DEFAULT_RADIUS = "1000";
    private static final String DEFAULT_LANGUAGE_CODE = "en";
    private static final String RANK_LOCATIONS_BY = "prominence";
    private static final String LOCATION_TYPE = "library";

    public SearchNearbyLocations() {
    }

    public List<Location> getNearbyLocations(Location loc) {
        String REQUEST_URI = SEARCH_REQUEST_URI + "location=" + loc.getLatitude() + "," +
                loc.getLongitude() + "&radius=" + DEFAULT_RADIUS + "&rankby=" + RANK_LOCATIONS_BY +
                "&keyword=" + loc.getdonationType().name() + "&key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(REQUEST_URI))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            if (response.statusCode() == 200) {
                return fromJSON(response.body());
            }
            else {
                log.error("operation=get-nearby-locations error=" + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            log.error("operation=get-nearby-locations error=" + e.getLocalizedMessage());
        }

        return null;
    }

    private List<Location> fromJSON(String jsonResponse) {
        return null;
    }

    public static void main(String[] args) {
        Location loc = new Location(1, "thrift", "rochester ny",
                -77.610924, 43.161030, Location.DonationAccepted.APPLICANCES);
//        System.out.println(getNearbyLocations(loc));
    }

}
