package cucumber.junit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.cucumber.pro.JsonReporter:aggregate"},
        features = "classpath:features",
        tags = {"@BowlingGame"},
        glue = "cucumber.steps"
)
public class CukeTests {

}
