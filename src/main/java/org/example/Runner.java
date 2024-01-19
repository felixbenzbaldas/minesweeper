package org.example;

public class Runner {
    public static void main(String[] args) {
        Board board = Board.createBoardAndDistributeMinesByRandom(200, 30, 3000);
        System.out.println(board.printBoard());
    }
}
