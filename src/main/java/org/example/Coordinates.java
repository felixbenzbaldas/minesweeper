package org.example;

import java.util.Map;

public class Coordinates {

    private final Map.Entry<Integer, Integer> mapEntry;
    public int getX() {
        return mapEntry.getKey();
    }
    public int getY() {
        return mapEntry.getValue();
    }
    public Coordinates(int x, int y) {
        mapEntry = Map.entry(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Coordinates) {
            return this.mapEntry.equals(((Coordinates) obj).mapEntry);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return mapEntry.hashCode();
    }

    @Override
    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }
}
