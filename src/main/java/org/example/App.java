package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        run(args[0], args[1]);
    }

    public static void run(String pathInputFile, String pathOutputFile) throws IOException {
        String input = getText(new File(pathInputFile));
        File file = new File(pathOutputFile);
        file.delete();
        file.createNewFile();
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(getOutput(input));
        }
    }

    private static String getText(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        return String.join("\n", lines);
    }

    public static String getOutput(String input) {
        List<String> lines = List.of(input.split("\n"));
        return getOutput(lines);
    }

    public static String getOutput(List<String> inputLines) {
        int height = inputLines.size();
        int width = inputLines.get(0).length();
        List<String> resultLines = new LinkedList<>();
        for (int y = 0; y < height; y++) {
            String inputLine = inputLines.get(y);
            StringBuilder resultLine = new StringBuilder();
            for (int x = 0; x < width; x++) {
                if (inputLine.charAt(x) == '*') {
                    resultLine.append('*');
                } else {
                    int minesInTheNeighbourhood = 0;
                    for (int nx = x - 1; nx <= x + 1; nx++) {
                        for (int ny = y - 1; ny <= y + 1; ny++) {
                            if (nx == x && ny == y) {
                                // do nothing
                            } else {
                                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                                    if (inputLines.get(ny).charAt(nx) == '*') {
                                        minesInTheNeighbourhood++;
                                    }
                                }
                            }
                        }
                    }
                    resultLine.append(minesInTheNeighbourhood);
                }
            }
            resultLines.add(resultLine.toString());
        }
        return String.join("\n", resultLines);
    }

}