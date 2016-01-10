package es.uma.lcc.riatec6.mastermind;

import android.util.Log;

import java.util.List;

import common.infraestructure.Constants;
import dal.MastermindHelper;
import domain.Ball;
import domain.Game;
import domain.Round;

/**
 * Created by algil on 10/01/16.
 */
public class BoardViewModel {

    private Game game;
    private Round actualRound;

    public BoardViewModel() {
        try {
            game = MastermindHelper.generateNewGame();
            actualRound = MastermindHelper.getRoundById(game, 1);

            for (Ball ball : game.getRightCombination()) {
                Log.d("BoardViewModel", "Ball: " + ball.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Round getActualRound() {
        return actualRound;
    }

    public void setActualRound(Round actualRound) {
        this.actualRound = actualRound;
    }

    public List<Round> getRounds() {
        return game.getRounds();
    }

    public void addBall(Ball ball) {
        actualRound.addBall(ball);
        if (MastermindHelper.isRoundComplete(actualRound)) {
            finishRound();
        }
    }

    private void finishRound() {
        MastermindHelper.resolveRound(game, actualRound);
        if (actualRound.getNumRound() == Constants.ROUNDS_NUMBER) {

        } else {
            actualRound = MastermindHelper.getRoundById(game, actualRound.getNumRound() + 1);
        }
    }
}
