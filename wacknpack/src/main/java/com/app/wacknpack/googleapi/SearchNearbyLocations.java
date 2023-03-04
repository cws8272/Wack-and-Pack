package com.app.wacknpack.googleapi;

import com.app.wacknpack.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
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
        Location loc = new Location("1", "thrift", "rochester ny",
                "43.161030", "-77.610924", Location.DonationAccepted.FOOD);
        System.out.println(getNearbyLocations(loc));
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
                System.out.println(response.body());
                return fromJSON(response.body(), loc.getdonationType());
            }
            else {
                log.error("operation=get-nearby-locations error=" + response.statusCode());
            }
        } catch (InterruptedException | IOException e) {
            log.error("operation=get-nearby-locations error=" + e.getLocalizedMessage());
        }

        return null;
    }

    private List<Location> fromJSON(String jsonResponse, Location.DonationAccepted donationAccepted) {
        List<Location> result = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(jsonResponse);
            JSONArray jsonLocations = obj.getJSONArray("results");

            for (int i= 0; i < jsonLocations.length(); i++) {
                JSONObject loc = jsonLocations.getJSONObject(i);
                String businessStatus = loc.getString("business_status");
                if (businessStatus.equals("OPERATIONAL")) {
                    String locationID = loc.getString("place_id");
                    String locationName = loc.getString("name");
                    String address = loc.getString("vicinity");
                    JSONObject geometry = loc.getJSONObject("geometry").getJSONObject("location");
                    String latitude = geometry.getString("lat");
                    String longitude = geometry.getString("lng");
                    result.add(new Location(locationID, locationName, address,
                            latitude, longitude, donationAccepted));
                }
                else {
                    log.info("operation=get-nearby-locations status=skipped-location description=non operational business");
                }

            }
        } catch (JSONException e) {
            log.error("operation=get-nearby-locations status=skipped-location description=" + e.getLocalizedMessage());
        }


        return result;
    }

    public static void main(String[] args) {
        new SearchNearbyLocations();
    }

}
