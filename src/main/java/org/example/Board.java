package org.example;

import java.util.*;

public class Board {

    private int height;
    private int width;

    private Set<Coordinates> mines = new HashSet<>();

    public Board(List<String> inputLines) {
        height = inputLines.size();
        width = inputLines.get(0).length();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (inputLines.get(y).charAt(x) == '*') {
                    mines.add(new Coordinates(x, y));
                }
            }
        }
    }

    public Board(int width, int height)  {
        this.width = width;
        this.height = height;
    }

    public static Board createBoard(int width, int height, int numberOfMines) {
        Board board = new Board(width, height);
        while (board.getNumberOfMines() < numberOfMines) {
            Coordinates freeField = board.getFreeFields().stream().findAny().get();
            List<Coordinates> freeFieldsList = new ArrayList<>(board.getFreeFields());
            Coordinates newMine = freeFieldsList.get((int) (Math.random() * freeFieldsList.size()));
            board.setMineAt(newMine.getX(), newMine.getY());
        }
        return board;
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
        for (Coordinates coordinates : new Coordinates(column, row).getAdjacentCoordinates()) {
            if (coordinates.getX() >= 0 && coordinates.getX() < width && coordinates.getY() >= 0 && coordinates.getY() < height) {
                if (hasMine(coordinates.getX(), coordinates.getY())) {
                    numberOfMines++;
                }
            }
        }
        return numberOfMines;
    }

    public boolean hasMine(int x, int y) {
        return mines.contains(new Coordinates(x, y));
    }

    @Override
    public String toString() {
        return getCheatsheet().replaceFirst("d", ".");
    }

    public void setMineAt(int x, int y) {
        mines.add(new Coordinates(x, y));
    }

    public int getNumberOfMines() {
        return mines.size();
    }

    public Set<Coordinates> getFreeFields() {
        HashSet<Coordinates> freeFields = new HashSet<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!hasMine(x, y)) {
                    freeFields.add(new Coordinates(x, y));
                }
            }
        }
        return freeFields;
    }

    public Set<Coordinates> getMines() {
        return mines;
    }
}
