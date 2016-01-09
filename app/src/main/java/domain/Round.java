package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Round {

    public static final int NUM_HOLES_ROUND = 4;

    private Integer id;
    private List<Ball> balls;
    private List<KeyPeg> result;
    private RoundState roundState;

    public Round() {
        this.id = null;
        this.balls = new ArrayList<>();
        this.result = new ArrayList<>();
        this.roundState = RoundState.Empty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void addCodePage(Ball ball) {
        if (isRoundStateFull()) {
            //TODO: Throw Exception to show a message?

        }

        this.balls.add(ball);

        if (this.balls.size() == NUM_HOLES_ROUND) {
            this.roundState = RoundState.Full;
        }
    }

    public List<KeyPeg> getResult() {
        return result;
    }

    public boolean isRoundStateEmpty() {
        return RoundState.Empty == this.roundState;
    }

    public boolean isRoundStateStarted() {
        return RoundState.Started == this.roundState;
    }

    public boolean isRoundStateFull() {
        return RoundState.Full == this.roundState;
    }
}
