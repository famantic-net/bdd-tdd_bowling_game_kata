package bowling;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
@CucumberOptions(
        publish = true,
        features = "src/test/resources",
        tags = "@BowlingGame",
        glue = "bowling"
)
public class RunCucumberTest {

}
