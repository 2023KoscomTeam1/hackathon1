package com.koscom.hackathon1.controller;

import com.koscom.hackathon1.domain.PlaceType;
import com.koscom.hackathon1.response.PlaceTypeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UtilityController {
    @GetMapping("/placeTypes")
    public PlaceTypeResponse getPlaceTypes() {
        PlaceTypeResponse placeTypeResponse = new PlaceTypeResponse();
        placeTypeResponse.setPlaceTypes(Arrays.asList(PlaceType.values()));

        return placeTypeResponse;
    }
}
