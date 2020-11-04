package bowling;

import java.util.ArrayList;
import java.util.List;


public class BowlingFrame {
    public List<Integer> rolls = new ArrayList<>();
    private int score = 0;
    private boolean spare = false;
    private boolean strike = false;

    public void addScore(int pins) {
        score += pins;
        if (rolls.size() == 1 & score == 10 ) {
            strike = true;
        }
        else if (rolls.size() == 2 & score == 10 ) {
            spare = true;
        }
    }

    public void add(int pins) {
        rolls.add(pins);
        addScore(pins);
    }

    public int getScore() {
        return score;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }
}
