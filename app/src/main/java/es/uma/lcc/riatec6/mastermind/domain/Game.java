package es.uma.lcc.riatec6.mastermind.domain;

import java.util.List;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Game {
    private List<Round> rounds;
    private Ball[] rightCombination;
    private int score;
    private GameState gameState;

    public Game() {
        this.rounds = null;
        rightCombination = new Ball[4];
        gameState = GameState.Playing;
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

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
