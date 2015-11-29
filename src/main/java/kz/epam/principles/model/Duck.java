package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.Position;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import org.apache.log4j.Logger;

public abstract class Duck {
    
    public final Logger DUCK_LOGGER = Logger.getLogger(Duck.class);

    protected Position position = new Position();
    protected boolean energy = true;

    public abstract void move(Location location, Command command) throws NotEnoughEnergyException, UnsupportedMovementException;

    public abstract void eat(Location location);

    public void quack() {
        DUCK_LOGGER.info("I'm quacking");
    }

    protected void walk(Command command) throws NotEnoughEnergyException {
        DUCK_LOGGER.info("I'm walking");
    }
}
