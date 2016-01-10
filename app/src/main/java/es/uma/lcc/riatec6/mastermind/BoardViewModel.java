package es.uma.lcc.riatec6.mastermind;

import android.util.Log;

import java.util.List;

import es.uma.lcc.riatec6.mastermind.dal.MastermindHelper;
import es.uma.lcc.riatec6.mastermind.domain.Ball;
import es.uma.lcc.riatec6.mastermind.domain.Game;
import es.uma.lcc.riatec6.mastermind.domain.GameState;
import es.uma.lcc.riatec6.mastermind.domain.Round;
import es.uma.lcc.riatec6.mastermind.listener.MastermindListener;

/**
 * Created by algil on 10/01/16.
 */
public class BoardViewModel {

    private Game game;
    private Round actualRound;
    private MastermindListener listener;

    public BoardViewModel(MastermindListener listener) {
        this.listener = listener;

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
        if (game.getGameState() == GameState.Playing) {
            actualRound = MastermindHelper.getRoundById(game, actualRound.getNumRound() + 1);

        } else if (game.getGameState() == GameState.Won) {
            listener.onGameWon(game);

        } else if (game.getGameState() == GameState.Lost) {
            listener.onGameLost(game);
        }
    }
}
