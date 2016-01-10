package es.uma.lcc.riatec6.mastermind.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.uma.lcc.riatec6.mastermind.common.DateUtils;
import es.uma.lcc.riatec6.mastermind.dao.constants.ConstantsDb;
import es.uma.lcc.riatec6.mastermind.dao.helpers.MasterMindDAOhelper;
import es.uma.lcc.riatec6.mastermind.dao.interfaces.IMasterMindDAO;
import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

/**
 * Created by LENOVO on 04/01/2016.
 */
public class MasterMindDAO implements IMasterMindDAO {
    private SQLiteDatabase sqlLiteDataBase;
    private Context context;


    public MasterMindDAO(Context context) {
        MasterMindDAOhelper daoHelper = new MasterMindDAOhelper(context);
        this.context = context;
        this.sqlLiteDataBase = daoHelper.getWritableDatabase();
    }


    @Override
    public void saveNewRakingRecord(PlayerRecord record) {
        int newRowId;
        ContentValues insertValues = null;

        try {
            insertValues = new ContentValues();

            insertValues.put(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_PLAYERNAME, record.getName());
            insertValues.put(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_POINTS, record.getScore());
            insertValues.put(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_REGISTER_DATE, DateUtils.dateToString(record.getRegisterDate()));

            newRowId = (int) sqlLiteDataBase.insert(ConstantsDb.RANKING_TABLE_NAME, null, insertValues);

        } catch(Exception ex) {
            Log.e("Error: ", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<PlayerRecord> getRankingRecords() {
        List<PlayerRecord> playerRecordList = null;
        String [] projection = null;
        Cursor resultSet = null;
        PlayerRecord playerRecord = null;

        try {
            projection = new String[4];
            playerRecordList = new ArrayList<PlayerRecord>();

            projection[0] = ConstantsDb.DB_MASTERMIND_TABLE_FIELD_ID;
            projection[1] = ConstantsDb.DB_MASTERMIND_TABLE_FIELD_PLAYERNAME;
            projection[2] = ConstantsDb.DB_MASTERMIND_TABLE_FIELD_POINTS;
            projection[3] = ConstantsDb.DB_MASTERMIND_TABLE_FIELD_REGISTER_DATE;

            resultSet = sqlLiteDataBase.query(ConstantsDb.RANKING_TABLE_NAME,
                                              projection,
                                              null,
                                              null,
                                              null,
                                              ConstantsDb.DB_MASTERMIND_TABLE_FIELD_POINTS + " DESC",
                                              null);

            if (resultSet.moveToFirst()) {
                do {
                    playerRecord = new PlayerRecord();

                    playerRecord.setId(resultSet.getInt(resultSet.getColumnIndex(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_ID)));
                    playerRecord.setName(resultSet.getString(resultSet.getColumnIndex(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_PLAYERNAME)));
                    playerRecord.setScore(resultSet.getInt(resultSet.getColumnIndex(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_POINTS)));
                    playerRecord.setRegisterDate(DateUtils.stringToDate(resultSet.getString(resultSet.getColumnIndex(ConstantsDb.DB_MASTERMIND_TABLE_FIELD_REGISTER_DATE))));

                    playerRecordList.add(playerRecord);
                } while(resultSet.moveToNext());
            }

            if (playerRecordList.isEmpty()) {
                playerRecordList = null;
            }

            return  playerRecordList;

        } catch(Exception ex) {
            Log.e("Error: ", ex.getMessage());
            throw ex;
        }
    }


}
