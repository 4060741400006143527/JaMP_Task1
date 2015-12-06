package kz.epam.principles.behavior;

public enum Location {

    WATER("water"),
    AIR("air"),
    LAND("land");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    public static Location getByValue(String value) {
        for (Location location : values()) {
            if (location.value.equals(value)) {
                return location;
            }
        }
        return null;
    }
}