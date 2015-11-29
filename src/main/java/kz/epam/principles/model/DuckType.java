package kz.epam.principles.model;

public enum DuckType {
    
    LIVE("live"),
    TOY("toy");
    
    private final String value;

    DuckType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DuckType getByValue(String value) {
        for (DuckType duckType : values()) {
            if (duckType.value.equals(value)) {
                return duckType;
            }
        }
        return null;
    }       
}
