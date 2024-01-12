package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        run(args[0], args[1]);
    }

    public static void run(String pathInputFile, String pathOutputFile) throws IOException {
        List<String> lines = Files.readAllLines(new File(pathInputFile).toPath());
        File file = new File(pathOutputFile);
        file.delete();
        file.createNewFile();
        try (PrintWriter out = new PrintWriter(file)) {
            out.print(getOutput(lines));
        }
    }

    public static String getOutput(List<String> inputLines) {
        return new Board(inputLines).getCheatsheet();
    }

}