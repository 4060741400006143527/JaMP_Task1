package kz.epam.principles.runner;

import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import kz.epam.principles.console.UserConsole;
import kz.epam.principles.maze.MazeReader;
import kz.epam.principles.maze.MazeSolver;
import kz.epam.principles.model.MovableDuck;
import kz.epam.principles.model.DuckType;
import org.apache.log4j.Logger;

public class Runner {

    public final static Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) throws Exception{

        UserConsole console = new UserConsole();
        DuckType duckType = console.readDuckType();
        MovableDuck duck = duckType.getDuck();

        Location location = console.readLocation();
        try {
            Action action = console.readAction();
            switch (action) {
                case PLAY:
                    play(console, duck, location);
                    break;
                case MAZE:
                    maze(duck, location);
                    break;
            }
        } catch (UnsupportedMovementException ex) {
            LOGGER.error(ex.getMessage());
            System.exit(0);
        }
    }

    private static void play(UserConsole console, MovableDuck duck, Location location)
            throws UnsupportedMovementException {

        while (true) {
            Command command = console.readCommand();
            try {
                duck.move(location, command);
            } catch (NotEnoughEnergyException ex) {
                LOGGER.error(ex.getMessage());
                System.out.println("You need to feed the duck. To do this, type 'feed'. "
                        + "If you want to leave the application, type 'exit'");
                if (console.readEatCommand()) {
                    duck.eat();
                }
            }
        }
    }

    private static void maze(MovableDuck duck, Location location) 
            throws UnsupportedMovementException {
        
        String[][] maze = MazeReader.readMaze("labirint.txt");
        MazeSolver mazeSolver = new MazeSolver(maze, duck);
        mazeSolver.solve(location);
    }
}
