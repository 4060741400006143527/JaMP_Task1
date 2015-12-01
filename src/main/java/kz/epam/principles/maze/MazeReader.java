package kz.epam.principles.maze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MazeReader {

    public static int[][] readMaze(String fileName) throws FileNotFoundException, IOException {
        InputStream fileInputStream = new FileInputStream(fileName);
        String[] lines = readLines(fileInputStream);
        int[][] maze = decimateHorizontally(lines);
        return maze;
    }

    private static String[] readLines(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "US-ASCII"));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines.toArray(new String[0]);
    }

    private static int[][] decimateHorizontally(String[] lines) {
        final int width = (lines[0].length() + 1) / 2;
        int[][] matrix = new int[lines.length][width];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(lines[i].charAt(j * 2)));
            }
        }
        return matrix;
    }
}
