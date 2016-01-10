package es.uma.lcc.riatec6.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.uma.lcc.riatec6.mastermind.domain.Ball;
import es.uma.lcc.riatec6.mastermind.domain.BallResult;
import es.uma.lcc.riatec6.mastermind.domain.Round;
import es.uma.lcc.riatec6.mastermind.R;

/**
 * Created by algil on 09/01/16.
 */
public class RoundAdapter extends ArrayAdapter<Round> {

    public RoundAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Round round = getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.round, null);

        } else {
            view = convertView;
        }

        TextView numRound = (TextView) view.findViewById(R.id.numRound);
        numRound.setText(String.valueOf(round.getNumRound()));

        ImageButton hole1 =  (ImageButton) view.findViewById(R.id.hole1);
        ImageButton hole2 =  (ImageButton) view.findViewById(R.id.hole2);
        ImageButton hole3 =  (ImageButton) view.findViewById(R.id.hole3);
        ImageButton hole4 =  (ImageButton) view.findViewById(R.id.hole4);

        hole1.setColorFilter(getColorBall(view, round.getBalls()[0]));
        hole2.setColorFilter(getColorBall(view, round.getBalls()[1]));
        hole3.setColorFilter(getColorBall(view, round.getBalls()[2]));
        hole4.setColorFilter(getColorBall(view, round.getBalls()[3]));

        ImageView result1 =  (ImageView) view.findViewById(R.id.result1);
        ImageView result2 =  (ImageView) view.findViewById(R.id.result2);
        ImageView result3 =  (ImageView) view.findViewById(R.id.result3);
        ImageView result4 =  (ImageView) view.findViewById(R.id.result4);

        result1.setColorFilter(getColorResult(view, round.getBallResults()[0]));
        result2.setColorFilter(getColorResult(view, round.getBallResults()[1]));
        result3.setColorFilter(getColorResult(view, round.getBallResults()[2]));
        result4.setColorFilter(getColorResult(view, round.getBallResults()[3]));

        return view;
    }

    private int getColorBall(View view, Ball ball) {
        int colorId = R.color.ballEmpty;
        if (ball != null) {
            colorId = ball.getColorId();
        }
        return view.getResources().getColor(colorId);
    }

    private int getColorResult(View view, BallResult ballResult) {
        int colorId = R.color.ballEmpty;
        if (ballResult != null) {
            colorId = ballResult.getColorId();
        }
        return view.getResources().getColor(colorId);
    }
}
