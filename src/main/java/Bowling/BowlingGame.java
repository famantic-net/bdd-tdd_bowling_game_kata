package Bowling;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("cucumber-glue")
public class BowlingGame {

    private int frameNumber = 0;
    private int score = 0;
    List<BowlingFrame> frameSet = new ArrayList<BowlingFrame>();
    private BowlingFrame currentFrame, prev1Frame, prev2Frame;


    public int getScore() {
        for (BowlingFrame frame:frameSet) {
            score += frame.getScore();
        }
        return score;
    };

    public BowlingGame() {
        currentFrame = new BowlingFrame();
        frameSet.add(currentFrame);
        frameNumber++;
    }

    public void roll(int pins) {
        if (frameIsFinished()) {
            prev2Frame = prev1Frame;
            prev1Frame = currentFrame;
            currentFrame = new BowlingFrame();
            frameSet.add(currentFrame);
            frameNumber++;
        }
        if (!(prev1Frame == null)) {
            if ((prev1Frame.isSpare() | prev1Frame.isStrike()) & isFirstRoll()) {
                prev1Frame.addScore(pins);
            }
            if (prev1Frame.isStrike() & isSecondRoll()) {
                prev1Frame.addScore(pins);
            }
        }
        if (!(prev2Frame == null)) {
            if (prev2Frame.isStrike() & prev1Frame.isStrike() & isFirstRoll()) {
                prev2Frame.addScore(pins);
            }
        }
        currentFrame.add(pins);
    }

    private boolean isFirstRoll() {
        return currentFrame.rolls.size() == 0;
    }

    private boolean isSecondRoll() {
        return currentFrame.rolls.size() == 1;
    }

    private boolean frameIsFinished() {
        boolean finished = false;

        if (frameSet.size() < 10 & (currentFrame.isStrike() | currentFrame.rolls.size() == 2)) {
            finished = true;
        }
        else if (frameSet.size() == 10) {
            if ((currentFrame.isStrike() | currentFrame.isSpare()) & currentFrame.rolls.size() == 3) {
                finished = true;
            }
        }
        return finished;
    }

}
