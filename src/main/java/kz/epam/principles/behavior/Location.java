package kz.epam.principles.behavior;

public enum Location {

    WATER("water"),
    AIR("air"),
    LAND("land");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

     public static Location getByValue(String value) {
        for (Location location : values()) {
            if (location.value.equals(value)) {
                return location;
            }
        }
        return null;
    }  
     
    public static Location getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
