package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import org.apache.log4j.Logger;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.EnegryChecker;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;

public class LiveDuck extends Duck {

    public final Logger LOGGER = Logger.getLogger(LiveDuck.class);

    @Override
    public void move(Location location, Command command) throws NotEnoughEnergyException, UnsupportedMovementException {

        energy = EnegryChecker.checkEnergy(position.getPosition(), position.isFailedStep());

        if (energy == false) {
            position.setFailedStep(true);
            throw new NotEnoughEnergyException();
        }

        switch (location) {
            case AIR:
                position.changePosition(command);
                fly(command);
                break;
            case LAND:
                position.changePosition(command);
                walk(command);
                break;
            case WATER:
                position.changePosition(command);
                swim(command);
                break;
            default:
                throw new UnsupportedMovementException();
        }
    }

    @Override
    public void eat(Location location) {
        if (Location.WATER.equals(location)) {
            LOGGER.info("I'm drinking");
        }
        LOGGER.info("I'm eating");
        energy = true;
    }

    private void fly(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm flying");
    }

    private void swim(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm swimming");
    }

}
