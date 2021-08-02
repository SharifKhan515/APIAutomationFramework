package org.qa.dataBuilder;

import org.qa.pojo.AddPlace;
import org.qa.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {


    public AddPlace addPlacePayload(String name, String language, String address ){
        AddPlace addPlace = new AddPlace();
        Location location = new Location();
        List<String> types = new ArrayList<>();
        types.add("First types");
        types.add("Second types");
        types.add("Third Types");
        location.setLat(-50.2369974);
        location.setLng(100.24455445);
        addPlace.setAccuracy(5);
        addPlace.setAddress(address);
        addPlace.setLanguage(language);
        addPlace.setName(name);
        addPlace.setPhone_number("1236588789865");
        addPlace.setTypes(types);
        addPlace.setLocation(location);
        addPlace.setWebsite("Abc.com");
        return addPlace;
    }


}
