package domain;

import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Game {
    private List<Round> rounds;

    public Game() {
        this.rounds = null;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }
}
