package es.uma.lcc.riatec6.mastermind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import es.uma.lcc.riatec6.mastermind.adapter.PlayerRecordAdapter;
import es.uma.lcc.riatec6.mastermind.dal.MasterMindDAL;
import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

public class HighScoresActivity extends AppCompatActivity {

    private static final String TAG_LOG = "HighScoresActivity";

    private ListView listHighScores;
    private PlayerRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        initList();
        loadData();
    }

    private void initList() {
        listHighScores = (ListView) findViewById(R.id.listHighScores);
        adapter = new PlayerRecordAdapter(this);
        listHighScores.setAdapter(adapter);
    }

    private void loadData() {
        try {
            MasterMindDAL dal = new MasterMindDAL(this);
            List<PlayerRecord> rankingRecordList = dal.getRankingRecords();

            if (rankingRecordList != null) {
                for (PlayerRecord playerRecord : rankingRecordList) {
                    adapter.add(playerRecord);
                }
            }

        } catch(Exception ex) {
            Toast.makeText(this, R.string.message_error_high_score, Toast.LENGTH_SHORT).show();
            Log.e(TAG_LOG, ex.getMessage(), ex);
        }
    }


}
