import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.example.App;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
public class ApprovalTest {

    @Test
    public void testFieldWithExactlyOneMine() {
        Approvals.verify(App.getOutput("*"));
    }

    @Test
    public void testFieldWithNoMine() {
        Approvals.verify(App.getOutput("."));
    }

    @Test
    public void testBoardWithTwoFields_oneMine() {
        Approvals.verify(App.getOutput("*."));
    }

    @Test
    public void testBoard() {
        Approvals.verify(App.getOutput(
                "*.\n" +
                "..\n"));
    }
    @Test
    public void testBoard2() {
        Approvals.verify(App.getOutput(
                ".*.\n" +
                ".*.\n" +
                ".**\n"));
    }

    @Test
    public void testBoard3() {
        Approvals.verify(App.getOutput(
                ".\n" +
                ".\n" +
                "*\n" +
                ".\n" +
                ".\n" +
                "*\n"));
    }

}
