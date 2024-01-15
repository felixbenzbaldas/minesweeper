package org.example;

public class Runner {
    public static void main(String[] args) {
        Board board = Board.createBoard(100, 15, 1000);
        System.out.println(board.printBoard());
    }
}
