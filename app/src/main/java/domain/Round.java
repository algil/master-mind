package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Round {

    private Integer id;
    private int numRound;
    private List<Ball> userBallCombinationSelected;
    private List<KeyPeg> keyPegRoundResult;
    private RoundState roundState;

    public Round() {
        this.id = null;
        this.userBallCombinationSelected = new ArrayList<>();
        this.keyPegRoundResult = new ArrayList<>();
        this.roundState = RoundState.Empty;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public int getNumRound() {
        return numRound;
    }

    public void setNumRound(int numRound) {
        this.numRound = numRound;
    }

    public List<Ball> getUserBallCombinationSelected() {
        return this.userBallCombinationSelected;
    }

    public void addUserBallCombination(Ball selectedBall) {
        this.userBallCombinationSelected.add(selectedBall);
    }


    public List<KeyPeg> getKeyPegRoundResult() {
        return keyPegRoundResult;
    }

    public void setKeyPegRound(List<KeyPeg> keyPegRoundResult) {
        this.keyPegRoundResult = keyPegRoundResult;
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
