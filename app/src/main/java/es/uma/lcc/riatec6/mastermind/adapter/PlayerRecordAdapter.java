package es.uma.lcc.riatec6.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import es.uma.lcc.riatec6.mastermind.R;
import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

/**
 * Created by algil on 10/01/16.
 */
public class PlayerRecordAdapter extends ArrayAdapter<PlayerRecord> {

    public PlayerRecordAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        PlayerRecord playerRecord = getItem(position);

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.player_record, null);

        } else {
            view = convertView;
        }

        TextView playerName = (TextView) view.findViewById(R.id.playerName);
        TextView score = (TextView) view.findViewById(R.id.score);

        playerName.setText(playerRecord.getName());
        score.setText(String.valueOf(playerRecord.getScore()));

        return view;
    }
}
