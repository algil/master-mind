package domain;

import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Game {
    private List<Round> rounds;
    private Ball[] rightCombination;

    public Game() {
        this.rounds = null;
        rightCombination = new Ball[4];
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public void setRightCombination(Ball[] rightCombination) {
        this.rightCombination = rightCombination;
    }

    public Ball[] getRightCombination() {
        return this.rightCombination;
    }
}
