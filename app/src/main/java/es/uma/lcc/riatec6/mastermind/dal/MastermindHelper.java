package es.uma.lcc.riatec6.mastermind.dal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.uma.lcc.riatec6.mastermind.common.infraestructure.Constants;
import es.uma.lcc.riatec6.mastermind.domain.Ball;
import es.uma.lcc.riatec6.mastermind.domain.BallResult;
import es.uma.lcc.riatec6.mastermind.domain.Game;
import es.uma.lcc.riatec6.mastermind.domain.GameState;
import es.uma.lcc.riatec6.mastermind.domain.Round;

/**
 * Created by LENOVO on 09/01/2016.
 */
public final class MastermindHelper {

    public static boolean isRoundComplete(Round round) {
        Ball ball = round.getBalls()[round.getBalls().length - 1];
        return ball != null;
    }

    public static Round getRoundById(Game game, int roundId) {
        Round roundFound = null;

        for (Round round : game.getRounds()) {
            if (round.getNumRound() == roundId) {
                roundFound = round;
                break;
            }
        }

        return roundFound;
    }

    public static void resolveRound(Game game, Round round) {

        try {
           Ball[] rightCombination = game.getRightCombination();
           List<Ball> rightCombinationToCheck = new ArrayList<Ball>(Arrays.asList(game.getRightCombination()));

            int contBlack = 0;
            int contWhite = 0;

            Ball ball;
            for (int i = 0; i < round.getBalls().length; i++) {
                ball = round.getBalls()[i];

                if (ball == rightCombination[i]) {
                    contBlack++;
                    if (rightCombinationToCheck.contains(ball)) {
                        rightCombinationToCheck.remove(rightCombinationToCheck.indexOf(ball));
                    }

                } else if (areBallColourInRigthCombination(rightCombinationToCheck, ball)) {
                    contWhite++;
                }
            }

            for (int i = 0; i < contBlack; i++) {
                round.addBallResult(BallResult.Black);
            }
            for (int i = 0; i < contWhite; i++) {
                round.addBallResult(BallResult.White);
            }

            game.addScore((contBlack * 10) * (Constants.ROUNDS_NUMBER - round.getNumRound()));
            game.addScore((contWhite * 5) * (Constants.ROUNDS_NUMBER - round.getNumRound()));

            if (contBlack == 4) {
                game.setGameState(GameState.Won);
            }

            if (round.getNumRound() == Constants.ROUNDS_NUMBER && contBlack != 4) {
                game.setGameState(GameState.Lost);
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    private static boolean areBallColourInRigthCombination(List<Ball> rightCombination,
                                                           Ball ballToCheck) {
        boolean ok = false;

        try {
            for (Ball ballInList : rightCombination) {
                if (ballInList.equals(ballToCheck)) {
                    ok = true;
                }
            }

            return ok;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private static List<Round> generateRounds() {
        List<Round> rounds = null;
        Round round = null;

        try {
            rounds = new ArrayList<>();

            for (int i = 1; i <= Constants.ROUNDS_NUMBER; i++) {
                round = new Round(i);
                rounds.add(round);
            }

            return rounds;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static Game generateNewGame() throws Exception {
        try {
            Game game = new Game();;
            Set<Ball> rightCombination = new HashSet<>();

            Ball randomBall;
            while (rightCombination.size() < 4) {
                randomBall = Ball.getRandom();
                if (!rightCombination.contains(randomBall)) {
                    rightCombination.add(randomBall);
                }
            }

            game.setRightCombination(rightCombination.toArray(new Ball[rightCombination.size()]));
            game.setRounds(MastermindHelper.generateRounds());

            return game;
        } catch (Exception ex) {
            throw ex;
        }
    }


}
