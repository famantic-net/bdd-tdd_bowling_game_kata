package bowling;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BowlingStepsGutterBall implements En {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    BowlingGame bowlingGame;

    public BowlingStepsGutterBall() {
        TestBowlingSuite suite = new TestBowlingSuite();

        When("^All balls miss all pins$", () -> {
            suite.testGutterGame(bowlingGame);
        });

        Then("^Game score is zero$", () -> {
            assertEquals(1,bowlingGame.getScore());
        });

    }


}
