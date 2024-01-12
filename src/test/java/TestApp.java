import org.approvaltests.Approvals;
import org.example.App;
import org.example.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        Board board = createBoard(1, 1, 1);

        Assertions.assertTrue(board.hasMine(0, 0));
    }

    @Test
    void canCreateBoardFullOfMines2() {
        Board board = createBoard(2, 2, 4);

        Approvals.verify(board);
    }

    @Test
    void canCreateBoardWithoutMines() {
        Board board = createBoard(1, 1, 0);

        Assertions.assertFalse(board.hasMine(0, 0));
    }

    private Board createBoard(int width, int height, int numberOfMines) {
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

}
