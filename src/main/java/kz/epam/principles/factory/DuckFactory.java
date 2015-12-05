package kz.epam.principles.factory;

import kz.epam.principles.model.DuckType;
import kz.epam.principles.model.MovableDuck;

public class DuckFactory {

    public static MovableDuck getDuck(DuckType duckType) {
        return duckType.getDuck(duckType);
    }

}
