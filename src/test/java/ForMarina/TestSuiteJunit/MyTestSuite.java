package ForMarina.TestSuiteJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MyTestcase1.class,
        MyTestcase2.class,
})

public class MyTestSuite {
    public class JunitTest {
        // This class remains empty, it is used only as a holder for the above annotations
    }
}
