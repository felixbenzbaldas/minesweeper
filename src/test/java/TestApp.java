import org.example.App;
import org.example.Board;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
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

        assertThat(board.hasMine(0, 0)).isTrue();
    }

    private Board createBoard(int width, int height, int numberOfMines) {
        return new Board(List.of("*"));
    }

}
