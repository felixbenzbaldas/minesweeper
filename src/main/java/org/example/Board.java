package org.example;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private List<String> inputLines;

    private int height;
    private int width;

    public Board(List<String> inputLines) {
        this.inputLines = inputLines;
        height = inputLines.size();
        width = inputLines.get(0).length();
    }

    public static Board createBoard(int width, int height) {
        return createBoard(width, height, 0);
    }

    public static Board createBoard(int width, int height, int numberOfMines) {
        List<String> lines = new LinkedList<>();
        for (int x = 0; x < width; x++) {
            StringBuilder line = new StringBuilder();
            for (int y = 0; y < height; y++) {
                if (numberOfMines > 0) {
                    line.append('*');
                } else {
                    line.append('.');
                }
            }
            lines.add(line.toString());
        }
        return new Board(lines);
    }

    public String getCheatsheet() {
        List<String> resultLines = new LinkedList<>();
        for (int y = 0; y < height; y++) {
            StringBuilder resultLine = new StringBuilder();
            for (int x = 0; x < width; x++) {
                if (hasMine(x, y)) {
                    resultLine.append('*');
                } else {
                    resultLine.append(getNumberOfAdjacentMines(x, y));
                }
            }
            resultLines.add(resultLine.toString());
        }
        return String.join("\n", resultLines);
    }

    private int getNumberOfAdjacentMines(int column, int row) {
        int numberOfMines = 0;
        for (int x = column - 1; x <= column + 1; x++) {
            for (int y = row - 1; y <= row + 1; y++) {
                if (x == column && y == row) {
                    // do nothing
                } else {
                    if (x >= 0 && x < width && y >= 0 && y < height) {
                        if (hasMine(x, y)) {
                            numberOfMines++;
                        }
                    }
                }
            }
        }
        return numberOfMines;
    }

    public boolean hasMine(int x, int y) {
        return inputLines.get(y).charAt(x) == '*';
    }

    @Override
    public String toString() {
        return getCheatsheet().replaceFirst("d", ".");
    }

    public void setMineAt(int x, int y) {

    }
}
