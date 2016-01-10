package es.uma.lcc.riatec6.mastermind.listener;

import domain.Game;

/**
 * Created by algil on 10/01/16.
 */
public interface MastermindListener {

    void onGameWon(Game game);

    void onGameLost(Game game);

}
