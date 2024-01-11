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
        return "*";
    }
}