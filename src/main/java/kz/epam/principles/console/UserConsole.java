package kz.epam.principles.console;

import java.util.Scanner;
import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.Location;
import kz.epam.principles.model.DuckType;

public class UserConsole {

    private final Scanner scanner = new Scanner(System.in);
    private String inputParameter;

    public DuckType readDuckType() {
        System.out.println("Select duck type, please. Available values: 'live', 'toy'");
        inputParameter = scanner.nextLine();
        isExit();
        DuckType duckType = DuckType.getByValue(inputParameter);
        if (duckType == null) {
            System.out.println("Incorrect duck type. Please, try again. "
                    + "If you want to leave the application, type 'exit'");
            readDuckType();
        }
        return duckType;
    }

    public Location readLocation() {
        System.out.println("Select duck location, please. Available values: 'water', 'land', 'air'");
        inputParameter = scanner.nextLine();
        isExit();
        Location location = Location.getByValue(inputParameter);
        if (location == null) {
            System.out.println("Incorrect location. Please, try again. "
                    + "If you want to leave the application, type 'exit'");
            readLocation();
        }
        return location;
    }

    public Command readCommand() {
        System.out.println("Input command for the duck, please. Available values: '1' - Up, '2' - Down, '3' - Right, '4' - Left");
        inputParameter = scanner.nextLine();
        isExit();
        Command command = Command.getByValue(Integer.valueOf(inputParameter));
        if (command == null) {
            System.out.println("Incorrect command. Please, try again. "
                    + "If you want to leave the application, type 'exit'");
            readCommand();
        }
        return command;
    }

    private void isExit() {
        if ("exit".equals(inputParameter)) {
            System.exit(0);
        }
    }

    public boolean readEatCommand() {
        inputParameter = scanner.nextLine();
        isExit();
        if ("feed".equals(inputParameter)) {
            return true;
        } else {
            System.out.println("Incorrect command. Please, try again. "
                    + "If you want to leave the application, type 'exit'");
            readEatCommand();
        }
        return false;
    }
}
