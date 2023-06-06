package org.example;

public class OccupiedPositionException extends RuntimeException{
    public int col;
    public int row;

    public OccupiedPositionException(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
