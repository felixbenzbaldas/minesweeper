package org.example;

import java.io.File;
import java.io.IOException;

public class App {
    public static void run(String pathInputFile, String pathOutputFile) throws IOException {
        File file = new File(pathOutputFile);
        file.createNewFile();
    }

    public static String getOutput(String input) {
        return "*";
    }
}