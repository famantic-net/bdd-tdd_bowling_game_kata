package bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        rollFrame(game,10);
        rollFrame(game,10);
        for (int j=2; j<10; j++) {
            rollFrame(game,0,0);
        }
        assertEquals(30, game.getScore());

    }

    public void rollFrame(BowlingGame game, int... rolls) {
        for (int ball : rolls) {game.roll(ball);}
    }

    @Test
    public void testRandomGame() {
        BowlingGame game = new BowlingGame();
        randomGame(game, new ArrayList<Integer>(Arrays.asList(5,5, 3,7, 2,8, 9,1, 4,5, 3,7, 8,2, 9,1, 10, 5,5,10)));
        assertEquals(164, game.getScore());
    }
    public void randomGame(BowlingGame game, List<Integer> rolls){
        for (int ball : rolls) {
            game.roll(ball);
        }
    }


}
