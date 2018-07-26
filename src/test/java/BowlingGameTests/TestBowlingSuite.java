package BowlingGameTests;

import Bowling.BowlingFrame;
import Bowling.BowlingGame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBowlingSuite {

    @Test
    public void testGutterGame() {
        BowlingGame game = new BowlingGame();
        testGutterGame(game);
    }
    public void testGutterGame(BowlingGame game) {

        for (int i=0; i<2; i++) {
            for (int j=0; j<10; j++) {
                game.roll(0);
            }
        }
        assertEquals(0,game.getScore());
    }

    @Test
    public void testSpare() {
        BowlingGame game = new BowlingGame();
        rollFrame(game,5,5);
        rollFrame(game,3,0);
        for (int j=2; j<10; j++) {
            rollFrame(game,0,0);
        }
        assertEquals(16, game.getScore());
    }

    @Test
    public void testStrike() {
        BowlingGame game = new BowlingGame();
        rollFrame(game,10,10);
        for (int j=1; j<10; j++) {
            rollFrame(game,0,0);
        }
        assertEquals(20, game.getScore());

    }

    public void rollFrame(BowlingGame game, int firstRoll, int secondRoll) {
        game.roll(firstRoll);
        game.roll(secondRoll);
    }
    public void rollFrame(BowlingGame game, int firstRoll, int secondRoll, int thirdRoll) {
        game.roll(firstRoll);
        game.roll(secondRoll);
        game.roll(thirdRoll);
    }

    @Test
    public void testStandardGame() {
        BowlingGame game = new BowlingGame();
        testGame(game, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(20, game.getScore());
    }
    public void testGame(
            BowlingGame game,
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
        rollFrame(game,f1r1,f1r2);
        rollFrame(game,f2r1,f2r2);
        rollFrame(game,f3r1,f3r2);
        rollFrame(game,f4r1,f4r2);
        rollFrame(game,f5r1,f5r2);
        rollFrame(game,f6r1,f6r2);
        rollFrame(game,f7r1,f7r2);
        rollFrame(game,f8r1,f8r2);
        rollFrame(game,f9r1,f9r2);
        rollFrame(game,f10r1,f10r2);
    }
    @Test
    public void testCreditedGame() {
        BowlingGame game = new BowlingGame();
        testGame(game, 10,1,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,10,10, 10);
        assertEquals(77, game.getScore());
    }
    public void testGame(
            BowlingGame game,
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
        rollFrame(game,f1r1,f1r2);
        rollFrame(game,f2r1,f2r2);
        rollFrame(game,f3r1,f3r2);
        rollFrame(game,f4r1,f4r2);
        rollFrame(game,f5r1,f5r2);
        rollFrame(game,f6r1,f6r2);
        rollFrame(game,f7r1,f7r2);
        rollFrame(game,f8r1,f8r2);
        rollFrame(game,f9r1,f9r2);
        rollFrame(game,f10r1,f10r2,f10r3);
    }
}
