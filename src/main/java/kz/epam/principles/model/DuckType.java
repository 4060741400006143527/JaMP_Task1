package kz.epam.principles.model;

import kz.epam.principles.factory.DuckCreator;

public enum DuckType implements DuckCreator {

    LIVE("live") {
                @Override
                public MovableDuck getDuck(DuckType duckType) {
                   return new LiveDuck();
                }
            },
    TOY("toy") {
                @Override
                public MovableDuck getDuck(DuckType duckType) {
                    return new ToyDuck();
                }
            };

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
