package es.uma.lcc.riatec6.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import domain.Round;
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

        return view;
    }
}
