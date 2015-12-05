package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.EnegryChecker;
import kz.epam.principles.behavior.Position;
import kz.epam.principles.behavior.WalkBehavior;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;

public class ToyDuck extends MovableDuck {

    @Override
    public void move(Location location, Command command) throws NotEnoughEnergyException, UnsupportedMovementException {

        Position position = getPosition();
        boolean energy = EnegryChecker.checkEnergy(position.getStepCount(), position.isFailedStep());
        position.setLocation(location);

        if (energy == false) {
            position.setFailedStep(true);
            for (int i = 0; i < 5; i++) {
                quack();
            }
            throw new NotEnoughEnergyException();
        }
        switch (location) {
            case AIR:
                fly(command);
                position.changePosition(command);
                break;
            case LAND:
                WalkBehavior.walk(command);
                position.changePosition(command);
                break;
            default:
                throw new UnsupportedMovementException();
        }
    }

    @Override
    public void eat() {
        LOGGER.info("I have changed a battery");
        setEnergy(true);
    }

    private void fly(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm flittering with wings");
    }
}
