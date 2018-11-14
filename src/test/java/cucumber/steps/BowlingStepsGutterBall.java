package cucumber.steps;

import bowlingtests.TestBowlingSuite;
import cucumber.api.java8.En;
import bowling.BowlingGame;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class BowlingStepsGutterBall implements En {

    @Autowired
    BowlingGame bowlingGame;

    public BowlingStepsGutterBall() {
        TestBowlingSuite suite = new TestBowlingSuite();

        When("^All balls miss all pins$", () -> {
            suite.testGutterGame(bowlingGame);
        });

        Then("^Game score is zero$", () -> {
            assertEquals(0,bowlingGame.getScore());
        });

    }


}
