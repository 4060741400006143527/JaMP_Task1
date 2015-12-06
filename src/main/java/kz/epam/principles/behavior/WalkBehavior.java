package kz.epam.principles.behavior;

import org.apache.log4j.Logger;

public class WalkBehavior {

    public static final Logger LOGGER = Logger.getLogger(WalkBehavior.class);

    public static void walk(Command command) {
        LOGGER.info("I'm walking to " + command);
    }
}
