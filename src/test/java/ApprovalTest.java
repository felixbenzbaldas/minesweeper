import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.example.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@UseReporter(DiffReporter.class)
public class ApprovalTest {

    public static final String EXAMPLE_OUTPUT_TXT = "example-output.txt";

    @Test
    public void testFieldWithExactlyOneMine() {
        Approvals.verify(App.getOutput(List.of("*")));
    }

    @Test
    public void testFieldWithNoMine() {
        Approvals.verify(App.getOutput(List.of(".")));
    }

    @Test
    public void testBoardWithTwoFields_oneMine() {
        Approvals.verify(App.getOutput(List.of("*.")));
    }

    @Test
    public void testBoard() {
        Approvals.verify(App.getOutput(List.of(
            "*.",
            "..")));
    }
    @Test
    public void testBoard2() {
        Approvals.verify(App.getOutput(List.of(
            ".*.",
            ".*.",
            ".**")));
    }

    @Test
    public void testBoard3() {
        Approvals.verify(App.getOutput(List.of(
            ".",
            ".",
            "*",
            ".",
            ".",
            "*")));
    }

    @Test
    void testWithFile() throws IOException {
        new File(EXAMPLE_OUTPUT_TXT).delete();

        App.main(new String[]{"example-input.txt", EXAMPLE_OUTPUT_TXT});

        Approvals.verify(new File(EXAMPLE_OUTPUT_TXT));
    }
}
