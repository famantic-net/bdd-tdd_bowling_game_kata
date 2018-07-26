package cucumber.steps;

import Bowling.BowlingGame;
import BowlingGameTests.TestBowlingSuite;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class BowlingStepsCukeTraditional implements En {

    @Autowired
    BowlingGame game;

    @When("^Play is (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+)$")
    public void withStandardLastFrame( // Seems cucumber lambda variant can't accept this many arguments
                                       Integer f1r1,
                                       Integer f1r2,
                                       Integer f2r1,
                                       Integer f2r2,
                                       Integer f3r1,
                                       Integer f3r2,
                                       Integer f4r1,
                                       Integer f4r2,
                                       Integer f5r1,
                                       Integer f5r2,
                                       Integer f6r1,
                                       Integer f6r2,
                                       Integer f7r1,
                                       Integer f7r2,
                                       Integer f8r1,
                                       Integer f8r2,
                                       Integer f9r1,
                                       Integer f9r2,
                                       Integer f10r1,
                                       Integer f10r2
    ) {
        TestBowlingSuite suite = new TestBowlingSuite();
        suite.testGame(game, f1r1,f1r2,f2r1,f2r2,f3r1,f3r2,f4r1,f4r2,f5r1,f5r2,f6r1,f6r2,f7r1,f7r2,f8r1,f8r2,f9r1,f9r2,f10r1,f10r2);
    }

    @When("^Play is (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+) (\\d+),(\\d+),(\\d+)$")
    public void withCreditedLastFrame( // Seems cucumber lambda variant can't accept this many arguments
                                       Integer f1r1,
                                       Integer f1r2,
                                       Integer f2r1,
                                       Integer f2r2,
                                       Integer f3r1,
                                       Integer f3r2,
                                       Integer f4r1,
                                       Integer f4r2,
                                       Integer f5r1,
                                       Integer f5r2,
                                       Integer f6r1,
                                       Integer f6r2,
                                       Integer f7r1,
                                       Integer f7r2,
                                       Integer f8r1,
                                       Integer f8r2,
                                       Integer f9r1,
                                       Integer f9r2,
                                       Integer f10r1,
                                       Integer f10r2,
                                       Integer f10r3
    ) {
        TestBowlingSuite suite = new TestBowlingSuite();
        suite.testGame(game, f1r1,f1r2,f2r1,f2r2,f3r1,f3r2,f4r1,f4r2,f5r1,f5r2,f6r1,f6r2,f7r1,f7r2,f8r1,f8r2,f9r1,f9r2,f10r1,f10r2,f10r3);
    }

}
