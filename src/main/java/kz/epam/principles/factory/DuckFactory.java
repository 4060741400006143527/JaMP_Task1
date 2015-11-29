package kz.epam.principles.factory;

import kz.epam.principles.model.Duck;
import kz.epam.principles.model.DuckType;
import kz.epam.principles.model.LiveDuck;
import kz.epam.principles.model.ToyDuck;

public class DuckFactory {

    public static Duck getDuck(DuckType duckType) {
        switch (duckType) {
            case LIVE:
                return new LiveDuck();
            case TOY:
                return new ToyDuck();
        }
        return null;
    }

}
