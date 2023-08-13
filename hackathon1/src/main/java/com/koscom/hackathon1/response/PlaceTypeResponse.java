package com.koscom.hackathon1.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.koscom.hackathon1.domain.PlaceType;

import java.util.List;

public class PlaceTypeResponse {
    @JsonProperty("place_types")
    private List<PlaceType> placeTypes;

    public List<PlaceType> getPlaceTypes() {
        return placeTypes;
    }

    public void setPlaceTypes(List<PlaceType> placeTypes) {
        this.placeTypes = placeTypes;
    }

    @Override
    public String toString() {
        return "PlaceTypeResponse{" +
                "placeTypes=" + placeTypes +
                '}';
    }
}
