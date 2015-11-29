package kz.epam.principles.model;

import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.EnegryChecker;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import org.apache.log4j.Logger;

public class ToyDuck extends Duck {
    
    public final Logger LOGGER = Logger.getLogger(ToyDuck.class);

    @Override
    public void move(Location location, Command command) throws NotEnoughEnergyException, UnsupportedMovementException {

        energy = EnegryChecker.checkEnergy(position.getPosition(), position.isFailedStep());

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
                walk(command);
                position.changePosition(command);
                break;
            default:
                throw new UnsupportedMovementException();
        }
    }

    @Override
    public void eat(Location location) {
        LOGGER.info("I have changed a battery");
        energy = true;
    }

    private void fly(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm flittering with wings");
    }
}
