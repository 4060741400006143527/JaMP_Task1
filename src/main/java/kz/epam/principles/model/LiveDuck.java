package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.EnegryChecker;
import kz.epam.principles.behavior.Position;
import kz.epam.principles.behavior.WalkBehavior;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;

public class LiveDuck extends MovableDuck {

    @Override
    public void move(Location location, Command command) throws NotEnoughEnergyException, UnsupportedMovementException {

        Position position = getPosition();
        boolean energy = EnegryChecker.checkEnergy(position.getStepCount(), position.isFailedStep());
        position.setLocation(location);

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
                WalkBehavior.walk(command);
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
    public void eat() {
        if (Location.WATER.equals(getPosition().getLocation())) {
            LOGGER.info("I'm drinking");
        }
        LOGGER.info("I'm eating");
        setEnergy(true);
    }

    private void fly(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm flying");
    }

    private void swim(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm swimming");
    }
}
