package domain;

import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Game {
    private List<Round> rounds;
    private List<Ball> rightCombination;

    public Game() {
        this.rounds = null;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public void setRightCombination(List<Ball> rightCombination) {
        this.rightCombination = rightCombination;
    }

    public List<Ball> getRightCombination() {
        return this.rightCombination;
    }
}
