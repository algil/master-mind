package es.uma.lcc.riatec6.mastermind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import domain.Ball;
import domain.Game;
import domain.Round;
import es.uma.lcc.riatec6.mastermind.adapter.RoundAdapter;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int NUM_ROUNDS = 12;

    private ListView roundList;
    private RoundAdapter adapter;

    BoardViewModel viewModel;

    private Game game;
    private Round actualRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        viewModel = new BoardViewModel();

        initRoundList();
        setListeners();
    }

    private void initRoundList() {
        roundList = (ListView) findViewById(R.id.roundList);
        adapter = new RoundAdapter(this);
        roundList.setAdapter(adapter);

        for (Round round : viewModel.getRounds()) {
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

    private void ballSelected(Ball ball) {
        viewModel.addBall(ball);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        Ball ball = null;

        switch (id) {
            case R.id.ballBlue:
                ball = Ball.Blue;
                break;
            case R.id.ballRed:
                ball = Ball.Red;
                break;
            case R.id.ballGreen:
                ball = Ball.Green;
                break;
            case R.id.ballYellow:
                ball = Ball.Yellow;
                break;
            case R.id.ballBrown:
                ball = Ball.Brown;
                break;
            case R.id.ballOrange:
                ball = Ball.Orange;
                break;
            default:
        }
        if (ball != null) {
            ballSelected(ball);
        }

    }
}
