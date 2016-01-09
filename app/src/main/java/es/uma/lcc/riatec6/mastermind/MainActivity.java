package es.uma.lcc.riatec6.mastermind;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.List;

import common.DateUtils;
import dal.MasterMindDAL;
import dal.MasterMindLogicHelper;
import domain.Ball;
import domain.Game;
import domain.KeyPeg;
import domain.PlayerRecord;
import domain.Round;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testPlayRound();
        //testSavePlayerRanking();
        //testLoadPlayerRanking();
    }

    private void testSavePlayerRanking() {
        MasterMindDAL dal = null;
        PlayerRecord playerRecord = null;

        try {
            dal = new MasterMindDAL(this);
            playerRecord = new PlayerRecord();
            playerRecord.setName("Antonio");
            playerRecord.setPoints(200);
            playerRecord.setRegisterDate(new Date());

            dal.saveNewRakingRecord(playerRecord);

            playerRecord = new PlayerRecord();
            playerRecord.setName("Tomi");
            playerRecord.setPoints(200);
            playerRecord.setRegisterDate(new Date());

            dal.saveNewRakingRecord(playerRecord);

        } catch(Exception ex) {
            Log.wtf("Error", ex);
            throw ex;
        }
    }

    private void testLoadPlayerRanking() {
        MasterMindDAL dal = null;
        List<PlayerRecord> rankingRecordList = null;

        try {
            dal = new MasterMindDAL(this);

            rankingRecordList = dal.getRankingRecords();

            if (rankingRecordList != null) {
                System.out.println("Ranking record List:");
                for (PlayerRecord record : rankingRecordList) {
                    System.out.println("ID: " + record.getId());
                    System.out.println("NAME: " + record.getName());
                    System.out.println("POINTS: " + record.getPoints());
                    System.out.println("REGISTER DATE: " + DateUtils.dateToString(record.getRegisterDate()));
                    System.out.println("------------------------");
                }
            }

        } catch(Exception ex) {
            Log.wtf("Error", ex);
            throw ex;
        }
    }


    private void testPlayRound() {

        Game game = null;


        try {
            game = MasterMindLogicHelper.generateNewGame();

            System.out.println("Correct combination: ");
            for (Ball item :game.getRightCombination()) {
                System.out.println("Ball: " + item);
            }

            //Play a round 1


            game.getRounds().get(0).addUserBallCombination(Ball.Yellow);
            game.getRounds().get(0).addUserBallCombination(Ball.Brown);
            game.getRounds().get(0).addUserBallCombination(Ball.Blue);
            game.getRounds().get(0).addUserBallCombination(Ball.Orange);

            //Verify round 1
            game.getRounds().get(0).setKeyPegRound(MasterMindLogicHelper.verifyGameRoundFromRoundId(game, 0));

            //View Round KeyPeg result
            System.out.println("KeyPeg result:");
            for (KeyPeg item : game.getRounds().get(0).getKeyPegRoundResult()) {
                System.out.println("KeyPeg: " + String.valueOf(item));
            }


        } catch(Exception ex) {
            Log.wtf("Error", ex);
        }
    }
}
