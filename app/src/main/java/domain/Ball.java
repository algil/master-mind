package domain;

import es.uma.lcc.riatec6.mastermind.R;

/**
 * Created by algil on 09/01/16.
 */
public enum Ball {
    Blue(R.color.ballBlue),
    Red(R.color.ballRed),
    Green(R.color.ballGreen),
    Yellow(R.color.ballYellow),
    Brown(R.color.ballBrown),
    Orange(R.color.ballOrange);

    private int colorId;

    Ball(int colorId) {
        this.colorId = colorId;
    }

    public int getColorId() {
        return colorId;
    }

    public static Ball getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
