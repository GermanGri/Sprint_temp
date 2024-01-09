package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.HomePageVerificationTest;
import tests.PositiveOrderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HomePageVerificationTest.class,
        HomePageVerificationTest.class,
        PositiveOrderTest.class
})
public class TestSuiteRunner {
}
