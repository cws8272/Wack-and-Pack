package com.app.wacknpack.controllers;

import com.app.wacknpack.googleapi.SearchNearbyLocations;
import com.app.wacknpack.model.Location;
import com.app.wacknpack.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("location")
public class LocationController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private final SearchNearbyLocations search;

    public LocationController(SearchNearbyLocations search) {
        this.search = search;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Location>> searchNearbyLocationTypes(@RequestParam String locationName, @RequestParam String longitude,
    @RequestParam String latitude, @RequestParam String donationType) {
        Location pinnedLocation = new Location("1", locationName, "123 Main", latitude, longitude,
                Location.DonationAccepted.FOOD);
        List<Location> result = search.getNearbyLocations(pinnedLocation);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
