package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.Position;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import org.apache.log4j.Logger;

public abstract class MovableDuck {

    public final Logger LOGGER = Logger.getLogger(MovableDuck.class);

    private Position position = new Position();
    private boolean energy = true;

    public abstract void move(Location location, Command command) 
            throws NotEnoughEnergyException, UnsupportedMovementException;

    public abstract void eat();

    public void quack() {
        LOGGER.info("I'm quacking");
    }

    public Position getPosition() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    public boolean isEnergy() {
        return energy;
    }

    protected void setEnergy(boolean energy) {
        this.energy = energy;
    }
}
