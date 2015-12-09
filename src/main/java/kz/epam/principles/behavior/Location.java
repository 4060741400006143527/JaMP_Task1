package kz.epam.principles.behavior;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kz.epam.principles.model.DuckType;

public enum Location {

    WATER("water"),
    AIR("air"),
    LAND("land");

    private final String value;
    private static final Map<String, Location> locations = Collections.unmodifiableMap(initializeLocations());

    Location(String value) {
        this.value = value;
    }

    public static Location getByValue(String value) {
        if (locations.containsKey(value)) {
            return locations.get(value);
        }
        return null;
    }
    
    private static Map<String, Location> initializeLocations() {
        Map<String, Location> locationMan = new HashMap<>();
        for (Location location : Location.values()) {
            locationMan.put(location.value, location);
        }
        return locationMan;
    }
}