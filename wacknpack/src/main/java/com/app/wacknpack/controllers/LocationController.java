package com.app.wacknpack.controllers;

import com.app.wacknpack.googleapi.SearchNearbyLocations;
import com.app.wacknpack.model.Location;
import com.app.wacknpack.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Location>> searchNearbyLocationTypes(Location location) {
        List<Location> result = search.getNearbyLocations(location);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
