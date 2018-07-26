package cucumber.steps;

import LambdaExamples.ScenarioWorld;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class StepDefinitions implements En{

    @Autowired
    ScenarioWorld scenarioWorld;

    public StepDefinitions() {
        When("^We call the start method$", () -> {
            System.out.println("Starting...\n");
            scenarioWorld.start();
        });

        Then("^The state has changed to started$", () -> {
            System.out.println("Started\n");
            assertEquals("Started", scenarioWorld.getState());
        });

    }

}
