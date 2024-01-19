import org.approvaltests.Approvals;
import org.example.App;
import org.example.Board;
import org.example.Coordinates;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestApp {
    @Test
    void shouldCreateNewTextfile() throws IOException {
        String pathInputFile = "input.txt";
        String pathOutputFile = "output.txt";
        new File(pathOutputFile).delete();

        App.run(pathInputFile, pathOutputFile);

        assertThat(new File(pathOutputFile)).exists();
    }

    @Test
    void canCreateBoardFullOfMines() {
        Board board = Board.createBoardAndDistributeMinesByRandom(1, 1, 1);

        assertTrue(board.hasMine(0, 0));
    }

    @Test
    void canCreateBoardFullOfMines2() {
        Board board = Board.createBoardAndDistributeMinesByRandom(2, 2, 4);

        Approvals.verify(board.printBoard());
    }

    @Test
    void canCreateBoardWithoutMines() {
        Board board = Board.createBoardAndDistributeMinesByRandom(1, 1, 0);

        assertFalse(board.hasMine(0, 0));
    }

    @Test
    void canSetMineInBoard() {
        Board board = new Board(10, 10);

        board.setMineAt(0, 0);

        assertTrue(board.hasMine(0, 0));
    }

    @Test
    void canSetMineInBoard2() {
        Board board = new Board(10, 10);

        board.setMineAt(1, 1);

        assertTrue(board.hasMine(1, 1));
    }

    @Test
    void canCreate4x4BoardWithTwoMines() {
        Board board = Board.createBoardAndDistributeMinesByRandom(2, 2, 2);

        assertThat(board.getNumberOfMines()).isEqualTo(2);
    }


    @Test
    void minesArePositionedByRandom() {
        int hits = 0;

        for (int i = 0; i < 1000; i++) {
            Board board = Board.createBoardAndDistributeMinesByRandom(1, 2, 1);
            Coordinates minePosition = board.getMines().stream().findAny().get();
            if (minePosition.equals(new Coordinates(0, 0))) {
                hits++;
            }
        }

        assertThat(hits).isGreaterThan(250);
        assertThat(hits).isLessThanOrEqualTo(750);
    }
}
