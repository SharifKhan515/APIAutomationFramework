package org.qa.dataBuilder;

public enum APIUri {

    AddPlaceAPI("maps/api/place/add/json"),
    getPlaceAPI("maps/api/place/get/json"),
    deletePlaceAPI("maps/api/place/delete/json");

    private final String uri;

    APIUri(String uri) {
        this.uri = uri;
    }

    public String getUri(){
        return uri;
    }

}
