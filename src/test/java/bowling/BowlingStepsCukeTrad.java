package bowling;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class BowlingStepsCukeTrad {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    BowlingGame game;

    @When("^All balls miss all pins$")
    public void allBallsMissAllPins() {
        TestBowlingSuite suite = new TestBowlingSuite();
        suite.testGutterGame(game);
    }

    @Then("^Game score is zero$")
    public void GameScoreZero() {
        assertEquals(0,game.getScore());
    }

    @When("^First frame is a spare$")
    public void firstFrameIsSpare() {
        TestBowlingSuite suite = new TestBowlingSuite();
        suite.rollFrame(game,5,5);
    }

    @When("^Next roll is a (\\d+)$")
    public void nextRoll(Integer pins) {
        TestBowlingSuite suite = new TestBowlingSuite();
        suite.rollFrame(game, pins,0);
    }

    @When("^First roll is a strike$")
    public void firstRollIsSTrike() {
        game.roll(10);
    }

    @When("^Second Roll is a strike$")
    public void secondRollIsStrike() {
        game.roll(10);
    }

    @When("^The rest from frame (\\d+) are gutterballs$")
    public void restFromFrameXGutterballs(Integer frame) {
        TestBowlingSuite suite = new TestBowlingSuite();
        for (int j=frame-1; j<10; j++) {
            suite.rollFrame(game,0,0);
        }
    }

    @When("^Play is$")
    public void randomPlayRow(DataTable table) {
        //List<String> frameSet = (List<String>) table.getTableConverter();
        List<List<String>> frameSetList = table.asLists(String.class);
        List<String> frameSet = frameSetList.get(0);
        randomPlay(frameSet);
    }

    @When("^Play is (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),?(\\d+)? (\\d+),(\\d+),?(\\d+)?$")
    public void randomPlaySetReceiver( // Seems cucumber lambda variant can't accept this many arguments
                                       String roll1,
                                       String roll2,
                                       String roll3,
                                       String roll4,
                                       String roll5,
                                       String roll6,
                                       String roll7,
                                       String roll8,
                                       String roll9,
                                       String roll10,
                                       String roll11,
                                       String roll12,
                                       String roll13,
                                       String roll14,
                                       String roll15,
                                       String roll16,
                                       String roll17,
                                       String roll18,
                                       String roll19,
                                       String roll20,
                                       String roll21
    ) {
        // Because cucumber can't handle varargs
        randomPlaySet(roll1, roll2, roll3, roll4, roll5, roll6, roll7, roll8, roll9, roll10, roll11, roll12, roll13, roll14, roll15, roll16, roll17, roll18, roll19, roll20, roll21);
    }

    @Then("^Game score is (\\d+)$")
    public void gameScore(Integer score) {
        assertEquals((int)score, (int)game.getScore());
    }

    public void randomPlay(List<String> frameSet) {
        //System.out.println("Play: " + frameSet + "\n");
        TestBowlingSuite suite = new TestBowlingSuite();
        List<Integer> rolls = new ArrayList<>();
        for (String frame : frameSet) {
            //System.out.println("Played FRAME: " + frame + "\n");
            List<String> frameRolls = Arrays.asList(frame.split("\\s*,\\s*"));
            for (String roll : frameRolls) {
                if (Pattern.matches(".*null.*", roll)) {
                    continue;
                }
                else {
                    if (Pattern.matches("[^\\d]\\d+", roll) || Pattern.matches("\\d+[^\\d]", roll)) {
                        roll = roll.replace("[", "").replace("]", "");
                    }
                    rolls.add(Integer.parseInt(roll));
                }
            }
        }
        suite.randomGame(game, rolls);

    }

    public void randomPlaySet(String... rolls) {
        List<String> frameSet = new ArrayList<>();
        List<String> frame = new ArrayList<>();
        int pos = 0;
        int frameSize;
        for (String roll : rolls) {
            pos++;
            frame.add(roll);
            if (pos < 19) {
                frameSize = 2;
            } else {
                frameSize = 3;
            }
            if (pos % frameSize == 0) {
                frameSet.add(frame.toString());
                frame = new ArrayList<>();
            }

        }
        randomPlay(frameSet);
    }
}
