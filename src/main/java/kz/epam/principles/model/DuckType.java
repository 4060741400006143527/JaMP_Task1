package kz.epam.principles.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kz.epam.principles.factory.DuckFactory;

public enum DuckType implements DuckFactory {

    LIVE("live") {
                @Override
                public MovableDuck getDuck() {
                    return new LiveDuck();
                }
            },
    TOY("toy") {
                @Override
                public MovableDuck getDuck() {
                    return new ToyDuck();
                }
            };

    private final String value;
    private static final Map<String, DuckType> duckTypes = Collections.unmodifiableMap(initializeDuckTypes());

    DuckType(String value) {
        this.value = value;
    }

    public static DuckType getByValue(String value) {
        if (duckTypes.containsKey(value)) {
            return duckTypes.get(value);
        }
        return null;
    }

    private static Map<String, DuckType> initializeDuckTypes() {
        Map<String, DuckType> duckTypeMap = new HashMap<>();
        for (DuckType duckType : DuckType.values()) {
            duckTypeMap.put(duckType.value, duckType);
        }
        return duckTypeMap;
    }
}
