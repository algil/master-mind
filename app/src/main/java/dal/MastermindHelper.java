package dal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.infraestructure.Constants;
import domain.Ball;
import domain.BallResult;
import domain.Game;
import domain.Round;

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

    /*public static Game verifyRightCombinationLastRoundGame(Game actualGame) {
        Round lastRoundGame = null;

        try {
            if (actualGame != null
                    && actualGame.getRounds() != null) {
                lastRoundGame = actualGame.getRounds().get(actualGame.getRounds().size() - 1);

                lastRoundGame.setKeyPegRound(verifyRoundIdFromGame(actualGame, lastRoundGame.getNumRound()));
            }

            return actualGame;
        } catch(Exception ex) {
            throw ex;
        }
    }*/

    public static void resolveRound(Game game, Round round) {

        try {
            Ball[] rightCombination = game.getRightCombination();

            int contBlack = 0;
            int contWhite = 0;

            Ball ball;
            for (int i = 0; i < round.getBalls().length; i++) {
                ball = round.getBalls()[i];

                if (ball == rightCombination[i]) {
                    contBlack++;

                } else if (areBallColourInRigthCombination(rightCombination, ball)) {
                    contWhite++;
                }
            }

            for (int i = 0; i < contBlack; i++) {
                round.addBallResult(BallResult.Black);
            }
            for (int i = 0; i < contWhite; i++) {
                round.addBallResult(BallResult.White);
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    private static boolean areBallColourInRigthCombination(Ball[] rightCombination,
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
            rounds = new ArrayList<Round>();

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

//            for (int i = 0; i < 4; i++) {
//                randomNumber = NumberUtils.calculateRandomNumberBetween1And4();
//                switch (randomNumber) {
//                    case 0:
//                        rightCombination.add(Ball.Blue);
//                        break;
//                    case 1:
//                        rightCombination.add(Ball.Brown);
//                        break;
//                    case 2:
//                        rightCombination.add(Ball.Green);
//                        break;
//                    case 3:
//                        rightCombination.add(Ball.Orange);
//                        break;
//                    case 4:
//                        rightCombination.add(Ball.Red);
//                        break;
//                    case 5:
//                        rightCombination.add(Ball.Yellow);
//                        break;
//                }
//            }

            game.setRightCombination(rightCombination.toArray(new Ball[rightCombination.size()]));
            game.setRounds(MastermindHelper.generateRounds());

            return game;
        } catch (Exception ex) {
            throw ex;
        }
    }


}
