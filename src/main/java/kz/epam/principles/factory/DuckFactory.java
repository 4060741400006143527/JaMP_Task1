package kz.epam.principles.factory;

import kz.epam.principles.model.DuckType;
import kz.epam.principles.model.MovableDuck;

public interface DuckFactory {
    
    MovableDuck getDuck(DuckType duckType);
}
