package kz.epam.principles.console;

import java.util.Scanner;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.Location;
import kz.epam.principles.model.DuckType;
import kz.epam.principles.runner.Action;

public class UserConsole {

    private final Scanner scanner = new Scanner(System.in);

    public DuckType readDuckType() {
        System.out.println("Select duck type, please. Available values: 'live', 'toy'");
        DuckType duckType = null;
        while (duckType == null) {
            String inputParameter = scanner.nextLine();
            performExitIfNeeded(inputParameter);
            duckType = DuckType.getByValue(inputParameter);
            if (duckType == null) {
                System.out.println("Incorrect duck type. Please, try again. "
                        + "If you want to leave the application, type 'exit'");
            }
        }
        return duckType;
    }

    public Location readLocation() {
        System.out.println("Select duck location, please. "
                + "Available values: 'water', 'land', 'air'");
        Location location = null;
        while (location == null) {
            String inputParameter = scanner.nextLine();
            performExitIfNeeded(inputParameter);
            location = Location.getByValue(inputParameter);
            if (location == null) {
                System.out.println("Incorrect location. Please, try again. "
                        + "If you want to leave the application, type 'exit'");
            }
        }
        return location;
    }

    public Command readCommand() {
        System.out.println("Input command for the duck, please. "
                + "Available values: '1' - Up, '2' - Down, '3' - Right, '4' - Left");
        Command command = null;
        while (command == null) {
            String inputParameter = scanner.nextLine();
            performExitIfNeeded(inputParameter);
            command = Command.getByValue(Integer.valueOf(inputParameter));
            if (command == null) {
                System.out.println("Incorrect command. Please, try again. "
                        + "If you want to leave the application, type 'exit'");
            }
        }
        return command;
    }

    public boolean readEatCommand() {
        String inputParameter = scanner.nextLine();
        while (!isFeed(inputParameter)) {
            performExitIfNeeded(inputParameter);
            if (isFeed(inputParameter)) {
                return true;
            } else {
                System.out.println("Incorrect command. Please, try again. "
                        + "If you want to leave the application, type 'exit'");
            }
            inputParameter = scanner.nextLine();
        }
        return false;
    }

    public Action readAction() {
        System.out.println("Select action, please. "
                + "Available values: 'manual duck play', 'duck in the maze'");
        Action action = null;
        while (action == null) {
            String inputParameter = scanner.nextLine();
            performExitIfNeeded(inputParameter);

            if (null != inputParameter) {
                switch (inputParameter) {
                    case "manual duck play":
                        action = Action.PLAY;
                        break;
                    case "duck in the maze":
                        action = Action.MAZE;
                        break;
                }
            }

            if (action == null) {
                System.out.println("Incorrect action. Please, try again. "
                        + "If you want to leave the application, type 'exit'");
            }
        }
        return action;
    }

    private static void performExitIfNeeded(String inputParameter) {
        if ("exit".equals(inputParameter)) {
            System.exit(0);
        }
    }

    private static boolean isFeed(String inputParameter) {
        return "feed".equals(inputParameter);
    }
}
