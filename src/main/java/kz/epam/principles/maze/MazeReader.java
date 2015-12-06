package kz.epam.principles.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MazeReader {

    public static String[][] readMaze(String fileName) {
        List<String[]> list = new ArrayList<>();
        String[][] maze;
        try {
            try (BufferedReader bufferedReader = 
                    new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()))) {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] row = s.split(" ");
                    list.add(row);
                }
                maze = new String[list.size()][];
                for (int i = 0; i < list.size(); ++i) {
                    maze[i] = list.get(i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maze;
    }
}
