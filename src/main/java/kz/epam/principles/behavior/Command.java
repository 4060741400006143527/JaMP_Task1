package kz.epam.principles.behavior;

public enum Command {

    UP(1),
    DOWN(2),
    RIGHT(3),
    LEFT(4);

    private final int value;

    Command(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Command getByValue(int value) {
        for (Command command : values()) {
            if (command.value == value) {
                return command;
            }
        }
        return null;
    }

    public static Command getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
