package cucumber.steps;

import bowling.BowlingGame;
import bowlingtests.TestBowlingSuite;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;


public class BowlingStepsCukeTrad implements En {

    @Autowired
    BowlingGame game;

}
