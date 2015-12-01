package kz.epam.principles.maze;

public class MazeSolver {

    int[][] maze;

    public MazeSolver(int[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {

        System.out.println();

        for (int[] row : maze) {
            for (int column = 0; column < row.length; column++) {
                System.out.print(row[column]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public boolean solve(int row, int column) {
        boolean done = false;
        if (isValid(row, column)) {
            maze[row][column] = 3;  // This way has been tried
            if (row == maze.length - 1 && column == maze[0].length - 1) {
                done = true;  // maze is solved
            } else {
                done = solve(row + 1, column);  // Down
                if (!done) {
                    done = solve(row, column + 1);  // Right
                }
                if (!done) {
                    done = solve(row - 1, column);  // Up
                }
                if (!done) {
                    done = solve(row, column - 1);  // Left
                }
            }
            if (done) {
                maze[row][column] = 7; // Successful way
            }
        }
        return done;
    }

    private boolean isValid(int row, int column) {
        boolean result = false;
        if (row >= 0 && row < maze.length && column >= 0 && column < maze[0].length) {
            if (maze[row][column] == 1) {
                result = true;
            }
        }
        return result;
    }
}
