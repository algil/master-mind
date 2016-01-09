package dal;

import java.util.ArrayList;
import java.util.List;

import common.NumberUtils;
import common.infraestructure.Constants;
import domain.Ball;
import domain.Game;
import domain.KeyPeg;
import domain.Round;

/**
 * Created by LENOVO on 09/01/2016.
 */
public final class MasterMindLogicHelper {

    public static Game verifyRightCombinationLastRoundGame(Game actualGame) {
        Round lastRoundGame = null;

        try {
            if (actualGame != null
                    && actualGame.getRounds() != null) {
                lastRoundGame = actualGame.getRounds().get(actualGame.getRounds().size() - 1);

                lastRoundGame.setKeyPegRound(verifyRoundIdFromGame(actualGame, lastRoundGame.getId()));
            }

            return actualGame;
        } catch(Exception ex) {
            throw ex;
        }
    }

    private static List<KeyPeg> verifyRoundIdFromGame(Game game,
                                                Integer roundId) {
        List<Round> roundList = null;
        List<Ball> rightCombination = null;
        List<KeyPeg> roundKeyPeg = null;
        Round foundRound = null;

        try {
            roundList = game.getRounds();
            rightCombination = game.getRightCombination();
            roundKeyPeg = new ArrayList<KeyPeg>();

            for (int i=0;i<roundList.size();i++) {
                foundRound = roundList.get(i);

                if (foundRound.getId().equals(roundId)) {
                    i = roundList.size();
                }
            }

            for (int i=0;i<foundRound.getUserBallCombinationSelected().size();i++) {
                if (foundRound.getUserBallCombinationSelected().get(i).equals(rightCombination.get(i))) {
                    roundKeyPeg.add(KeyPeg.Black);
                } else if (areBallColourInRigthCombination(rightCombination,
                            foundRound.getUserBallCombinationSelected().get(i))) {
                    roundKeyPeg.add(KeyPeg.White);
                } else {
                    roundKeyPeg.add(KeyPeg.None);
                }
            }

            return roundKeyPeg;
        } catch(Exception ex) {
            throw ex;
        }
    }

    private static boolean areBallColourInRigthCombination(List<Ball> rightCombination,
                                                           Ball ballToCheck) {
        boolean ok = false;

        try {
            for (Ball ballInList: rightCombination) {
                if (ballInList.equals(ballToCheck)) {
                    ok = true;
                }
            }

            return ok;
        } catch(Exception ex) {
            throw ex;
        }
    }

    private static List<Round> generateRounds() {
        List<Round> rounds = null;
        Round round = null;

        try {
            rounds = new ArrayList<Round>();

            for(int i=0;i< Constants.ROUNDS_NUMBER; i++) {
                round = new Round();

                round.setId(i+1);
                rounds.add(round);
            }

            return rounds;
        } catch(Exception ex) {
            throw ex;
        }
    }

    public static Game generateNewGame() throws Exception {
        Game game = null;
        List<Ball> rightCombination = null;
        int randomNumber = 0;

        try {
            game = new Game();
            rightCombination = new ArrayList<Ball>();

            for (int i = 0; i < 4; i++) {
                randomNumber = NumberUtils.calculateRandomNumberBetween1And4();
                switch(randomNumber) {
                    case 0:
                        rightCombination.add(Ball.Blue);
                        break;
                    case 1:
                        rightCombination.add(Ball.Brown);
                        break;
                    case 2:
                        rightCombination.add(Ball.Green);
                        break;
                    case 3:
                        rightCombination.add(Ball.Orange);
                        break;
                    case 4:
                        rightCombination.add(Ball.Red);
                        break;
                    case 5:
                        rightCombination.add(Ball.Yellow);
                        break;
                }
            }

            game.setRightCombination(rightCombination);
            game.setRounds(MasterMindLogicHelper.generateRounds());

            return game;
        } catch(Exception ex) {
            throw ex;
        }
    }


}
