package cucumber.steps;

import bowling.BowlingGame;
import bowlingtests.TestBowlingSuite;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

//@SpringBootTest
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
