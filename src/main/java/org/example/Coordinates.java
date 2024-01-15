package org.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Set<Coordinates> getAdjacentCoordinates() {
        Set<Coordinates> toReturn = new HashSet<>();
        for (int x = this.getX() - 1; x <= this.getX() + 1; x++) {
            for (int y = this.getY() - 1; y <= this.getY() + 1; y++) {
                if (!this.equals(new Coordinates(x, y))) {
                    toReturn.add(new Coordinates(x, y));
                }
            }
        }
        return toReturn;
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
