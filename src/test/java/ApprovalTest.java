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
}