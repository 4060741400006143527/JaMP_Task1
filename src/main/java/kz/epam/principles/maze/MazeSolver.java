package kz.epam.principles.maze;

import kz.epam.principles.behavior.Command;
import kz.epam.principles.behavior.Location;
import kz.epam.principles.behavior.exception.NotEnoughEnergyException;
import kz.epam.principles.behavior.exception.UnsupportedMovementException;
import kz.epam.principles.model.MovableDuck;
import org.apache.log4j.Logger;

public class MazeSolver {

    public final Logger LOGGER = Logger.getLogger(MazeSolver.class);

    private final String[][] maze;
    private final MovableDuck duck;

    public MazeSolver(String[][] maze, MovableDuck duck) {
        this.maze = maze;
        this.duck = duck;
    }

    public void solve(Location location) throws UnsupportedMovementException {
        printMaze();

        if (solve(0, 0, location)) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("No solution");
        }
        printMaze();

    }

    public boolean solve(int row, int column, Location location) throws UnsupportedMovementException {
        boolean isSolved = false;
        if (isValid(row, column)) {

            if ("X".equals(maze[row][column])) {
                isSolved = true;
            } else {
                maze[row][column] = "-";  // This way has been tried
                moveDuck(row, column, location, Command.DOWN);
                isSolved = solve(row + 1, column, location);
                if (!isSolved) {
                    moveDuck(row, column, location, Command.RIGHT);
                    isSolved = solve(row, column + 1, location);
                    if (!isSolved) {
                        moveDuck(row, column, location, Command.UP);
                        isSolved = solve(row - 1, column, location);
                    }
                    if (!isSolved) {
                        moveDuck(row, column, location, Command.LEFT);
                        isSolved = solve(row, column - 1, location);
                    }
                }
            }
            if (isSolved) {
                maze[row][column] = "*"; // Successful way
            }
        }
        return isSolved;
    }

    private boolean isValid(int row, int column) {
        boolean result = false;
        if (row >= 0 && row < maze.length && column >= 0 && column < maze[0].length) {
            if ("0".equals(maze[row][column]) || "X".equals(maze[row][column])) {
                result = true;
            }
        }
        return result;
    }

    private void moveDuck(int row, int column, Location location, Command command) 
            throws UnsupportedMovementException {
        try {
            duck.move(location, command);
        } catch (NotEnoughEnergyException ex) {
            LOGGER.error(ex.getMessage());
            duck.eat();
            solve(row, column, location);
        }
    }

    public void printMaze() {
        System.out.println();
        for (String[] row : maze) {
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.println();
    }
}
