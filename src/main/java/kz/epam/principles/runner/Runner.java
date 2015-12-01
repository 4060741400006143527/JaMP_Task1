package kz.epam.principles.runner;

import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import kz.epam.principles.console.UserConsole;
import kz.epam.principles.factory.DuckFactory;
import kz.epam.principles.model.Duck;
import kz.epam.principles.model.DuckType;

public class Runner {

    public static void main(String[] args) throws  Exception {

        UserConsole console = new UserConsole();

        DuckType duckType = console.readDuckType();
        Duck duck = DuckFactory.getDuck(duckType);

        Location location = console.readLocation();

        while (true) {
            Command command = console.readCommand();
            try {
                duck.move(location, command);
            } catch (NotEnoughEnergyException ex) {
                System.out.println("I want to eat!");
                System.out.println("You need to feed the duck. To do this, type 'feed'. "
                        + "If you want to leave the application, type 'exit'");
                if (console.readEatCommand()) {
                    duck.eat(location);
                }
            } catch (UnsupportedMovementException ex) {
                System.out.println("This type of the duck can't do this action, try to choose another one next time");
                System.exit(0);
            }
        }

//        int[][] maze = MazeReader.readMaze("D://1.txt");
//
//        MazeSolver mazeSolver = new MazeSolver(maze);
//
//        mazeSolver.printMaze();
//
//        if (mazeSolver.solve(0, 0)) {
//            System.out.println("Maze solved!");
//        } else {
//            System.out.println("No solution");
//        }
//
//        mazeSolver.printMaze();
    }
}
