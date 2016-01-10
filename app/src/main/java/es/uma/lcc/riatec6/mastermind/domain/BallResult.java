package es.uma.lcc.riatec6.mastermind.domain;

import es.uma.lcc.riatec6.mastermind.R;

/**
 * Created by algil on 09/01/16.
 */
public enum BallResult {
    White(R.color.ballWhite),
    Black(R.color.ballBlack);

    private int colorId;

    BallResult(int colorId) {
        this.colorId = colorId;
    }

    public int getColorId() {
        return colorId;
    }
}
