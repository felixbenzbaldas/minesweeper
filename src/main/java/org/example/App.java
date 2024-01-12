package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class App {
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
        for (int x = 0; x < width; x++) {
            String inputLine = inputLines.get(x);
            StringBuilder resultLine = new StringBuilder();
            for (int y = 0; y < height; y++) {
                if (inputLine.charAt(0) == '*') {
                    resultLine.append('*');
                } else {
                    int minesInTheNeighbourhood = 0;
                    resultLine.append(minesInTheNeighbourhood);
                }
            }
            resultLines.add(resultLine.toString());
        }
        return String.join("\n", resultLines);
    }

}