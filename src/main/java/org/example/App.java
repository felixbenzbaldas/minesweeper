package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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

    public static String getOutput(List<String> lines) {
        int height = lines.size();
        int width = lines.get(0).length();
        for (int x = 0; x < width; x++) {
            String line = lines.get(x);
            for (int y = 0; y < height; y++) {
                int minesInTheNeighbourhood = 0;
            }
            if (line.charAt(0) == '*') {
                return "*";
            } else {
                return String.valueOf(0);
            }
        }
        return null;
    }

}