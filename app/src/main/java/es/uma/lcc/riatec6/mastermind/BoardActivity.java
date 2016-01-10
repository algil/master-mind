package es.uma.lcc.riatec6.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import domain.Round;
import es.uma.lcc.riatec6.mastermind.adapter.RoundAdapter;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NUM_ROUNDS = 12;

    private ListView roundList;
    private RoundAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        initRoundList();
        setListeners();
    }

    private void initRoundList() {
        roundList = (ListView) findViewById(R.id.roundList);
        adapter = new RoundAdapter(this);
        roundList.setAdapter(adapter);

        Round round = null;
        for (int i = 1; i <= NUM_ROUNDS; i++) {
            round = new Round();
            round.setNumRound(i);
            adapter.insert(round, 0);
        }
    }

    private void setListeners() {
        ImageButton ballBlue = (ImageButton) findViewById(R.id.ballBlue);
        ImageButton ballRed = (ImageButton) findViewById(R.id.ballRed);
        ImageButton ballGreen = (ImageButton) findViewById(R.id.ballGreen);
        ImageButton ballYellow = (ImageButton) findViewById(R.id.ballYellow);
        ImageButton ballBrown = (ImageButton) findViewById(R.id.ballBrown);
        ImageButton ballOrange = (ImageButton) findViewById(R.id.ballOrange);

        ballBlue.setOnClickListener(this);
        ballRed.setOnClickListener(this);
        ballGreen.setOnClickListener(this);
        ballYellow.setOnClickListener(this);
        ballBrown.setOnClickListener(this);
        ballOrange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        String colorBola = "";

        switch (id) {
            case R.id.ballBlue:
                colorBola = "Blue";
                break;
            case R.id.ballRed:
                colorBola = "Red";
                break;
            case R.id.ballGreen:
                colorBola = "Green";
                break;
            case R.id.ballYellow:
                colorBola = "Yellow";
                break;
            case R.id.ballBrown:
                colorBola = "Brown";
                break;
            case R.id.ballOrange:
                colorBola = "Orange";
                break;
            default:
        }

        Log.d("MainActivity", "La bola seleccionada es de color " + colorBola);
    }
}
