package es.uma.lcc.riatec6.mastermind;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import domain.Ball;
import domain.Game;
import domain.Round;
import es.uma.lcc.riatec6.mastermind.adapter.RoundAdapter;
import es.uma.lcc.riatec6.mastermind.listener.MastermindListener;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener, MastermindListener {

    private ListView roundList;
    private RoundAdapter adapter;
    private BoardViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        viewModel = new BoardViewModel(this);

        initRoundList();
        setListeners();
    }

    private void initRoundList() {
        roundList = (ListView) findViewById(R.id.roundList);
        adapter = new RoundAdapter(this);
        roundList.setAdapter(adapter);

        initDataList();
    }

    private void initDataList() {
        for (Round round : viewModel.getRounds()) {
            adapter.insert(round, 0);
        }
        adapter.notifyDataSetChanged();
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

    @Override
    public void onGameWon(Game game) {
        createWonDialog(game, R.string.won_title, R.string.won_description).show();
    }

    @Override
    public void onGameLost(Game game) {
        createLostDialog(game, R.string.lost_title, R.string.lost_description).show();
    }

    public AlertDialog createWonDialog(final Game game, int title, int description) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.game_dialog, null);
        builder.setView(view);

        setDataDialogView(view, game, title, description);

        TextView textScore = (TextView) view.findViewById(R.id.textScore);
        textScore.setText(getString(R.string.score, game.getScore()));

        final EditText editNamePlayer = (EditText) view.findViewById(R.id.editNamePlayer);

        builder.setPositiveButton(R.string.submit_score, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                submitScore(editNamePlayer.getText().toString(), game.getScore());
            }
        });

        return builder.create();
    }

    public AlertDialog createLostDialog(final Game game, int title, int description) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.game_dialog, null);
        builder.setView(view);

        setDataDialogView(view, game, title, description);

        TextView textScore = (TextView) view.findViewById(R.id.textScore);
        textScore.setVisibility(View.GONE);

        final EditText editNamePlayer = (EditText) view.findViewById(R.id.editNamePlayer);
        editNamePlayer.setVisibility(View.GONE);

        builder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        });
        builder.setNegativeButton(R.string.go_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        return builder.create();
    }

    private void setDataDialogView(View view, Game game, int title, int description) {
        TextView textTitle = (TextView) view.findViewById(R.id.textTitle);
        textTitle.setText(title);

        TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
        textDescription.setText(description);

        ImageView ball1 = (ImageView) view.findViewById(R.id.ball1);
        ball1.setColorFilter(view.getResources().getColor(game.getRightCombination()[0].getColorId()));
        ImageView ball2 = (ImageView) view.findViewById(R.id.ball2);
        ball2.setColorFilter(view.getResources().getColor(game.getRightCombination()[1].getColorId()));
        ImageView ball3 = (ImageView) view.findViewById(R.id.ball3);
        ball3.setColorFilter(view.getResources().getColor(game.getRightCombination()[2].getColorId()));
        ImageView ball4 = (ImageView) view.findViewById(R.id.ball4);
        ball4.setColorFilter(view.getResources().getColor(game.getRightCombination()[3].getColorId()));
    }

    private void submitScore(String namePlayer, int score) {
        //TODO: Guardar la puntuacion

        finish();
    }

    private void newGame() {
        viewModel = new BoardViewModel(this);
        initDataList();
    }
}
