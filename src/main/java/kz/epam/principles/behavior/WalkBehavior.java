package kz.epam.principles.behavior;

import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import org.apache.log4j.Logger;

public class WalkBehavior {

    public static final Logger LOGGER = Logger.getLogger(WalkBehavior.class);

    public static void walk(Command command) throws NotEnoughEnergyException {
        LOGGER.info("I'm walking");
    }
}
