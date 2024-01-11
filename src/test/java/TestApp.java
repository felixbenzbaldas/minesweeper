import org.example.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class TestApp {
    @Test
    void shouldCreateNewTextfile() throws IOException {
        String pathInputFile = "input.txt";
        String pathOutputFile = "output.txt";
        new File(pathOutputFile).delete();

        App.run(pathInputFile, pathOutputFile);

        assertThat(new File(pathOutputFile)).exists();
    }

}
