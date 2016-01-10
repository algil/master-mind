package domain;

/**
 * Created by LENOVO on 05/01/2016.
 */
public class Round {

    private int numRound;
    private Ball[] balls;
    private BallResult[] ballResults;
    private RoundState roundState;

    public Round(int numRound) {
        this.numRound = numRound;
        this.balls = new Ball[4];
        this.ballResults = new BallResult[4];
        this.roundState = RoundState.Empty;
    }

    public int getNumRound() {
        return this.numRound;
    }

    public Ball[] getBalls() {
        return this.balls;
    }

    public void addBall(Ball ball) {
        if (balls[0] == null) {
            balls[0] = ball;

        } else if (balls[1] == null) {
            balls[1] = ball;

        } else if (balls[2] == null) {
            balls[2] = ball;

        } else if (balls[3] == null) {
            balls[3] = ball;
        }
    }

    public void addBallResult(BallResult ballResult) {
        if (ballResults[0] == null) {
            ballResults[0] = ballResult;

        } else if (ballResults[1] == null) {
            ballResults[1] = ballResult;

        } else if (ballResults[2] == null) {
            ballResults[2] = ballResult;

        } else if (ballResults[3] == null) {
            ballResults[3] = ballResult;
        }
    }

    public BallResult[] getBallResults() {
        return ballResults;
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
