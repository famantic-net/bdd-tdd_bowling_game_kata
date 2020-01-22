package cucumber.steps;

import bowling.BowlingGame;
import bowlingtests.TestBowlingSuite;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class BowlingStepsLambdas implements En {

    @Autowired
    BowlingGame game;

    public BowlingStepsLambdas() {
        TestBowlingSuite suite = new TestBowlingSuite();

        When("^All balls miss all pins$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^Game score is zero$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^First frame is a spare$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^Next roll is a (\\d+)$", (Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^The rest from frame (\\d+) are gutterballs$", (Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^Game score is (\\d+)$", (Integer arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^First roll is a srike$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^Second Roll is a strike$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^Play is$", (DataTable arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
            // E,K,V must be a scalar (String, Integer, Date, enum etc).
            // Field names for YourType must match the column names in
            // your feature file (except for spaces and capitalization).
            throw new PendingException();
        });



    }


}
