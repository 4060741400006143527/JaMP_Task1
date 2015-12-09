package kz.epam.principles.behavior;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Command {

    UP(1),
    DOWN(2),
    RIGHT(3),
    LEFT(4);

    private final int value;
    private static final Map<Integer, Command> commands = Collections.unmodifiableMap(initializeCommands());

    Command(int value) {
        this.value = value;
    }

    public static Command getByValue(int value) {
         if (commands.containsKey(value)) {
            return commands.get(value);
        }
        return null;
    }

    private static Map<Integer, Command> initializeCommands() {
        Map<Integer, Command> commandMap = new HashMap<>();
        for (Command command : Command.values()) {
            commandMap.put(command.value, command);
        }
        return commandMap;
    }
}
