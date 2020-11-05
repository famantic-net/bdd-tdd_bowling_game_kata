package bowling;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class BowlingStepsLambdas implements En {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BowlingGame game;

    public BowlingStepsLambdas() {
        TestBowlingSuite suite = new TestBowlingSuite();

        When("^First frame is a spare$", () -> {
            suite.rollFrame(game,5,5);
        });

        When("^Next roll is a (\\d+)$", (Integer pins) -> {
            suite.rollFrame(game, pins,0);
        });

        When("^First roll is a strike$", () -> {
            game.roll(10);
        });

        When("^Second Roll is a strike$", () -> {
            game.roll(10);
        });

        When("^The rest from frame (\\d+) are gutterballs$", (Integer frame) -> {
            for (int j=frame-1; j<10; j++) {
                suite.rollFrame(game,0,0);
            }
        });

        Then("^Game score is (\\d+)$", (Integer score) -> {
            assertEquals((int)score, (int)game.getScore());
        });

    }


}
