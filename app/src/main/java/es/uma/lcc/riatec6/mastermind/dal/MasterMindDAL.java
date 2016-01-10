package es.uma.lcc.riatec6.mastermind.dal;

import android.content.Context;
import android.util.Log;

import java.util.List;

import es.uma.lcc.riatec6.mastermind.api.IMasterMindDAL;
import es.uma.lcc.riatec6.mastermind.dao.MasterMindDAO;
import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

/**
 * Created by LENOVO on 04/01/2016.
 */
public class MasterMindDAL implements IMasterMindDAL {
    private Context context;
    private MasterMindDAO masterMindDAO;

    public MasterMindDAL(Context context) {
        this.context = context;
        this.masterMindDAO = new MasterMindDAO(this.context);
    }


    @Override
    public void saveNewRakingRecord(PlayerRecord record) {
        try {
            masterMindDAO.saveNewRakingRecord(record);
        } catch(Exception ex) {
            Log.e("Error: " , ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<PlayerRecord> getRankingRecords() {
        try {
            return masterMindDAO.getRankingRecords();
        } catch(Exception ex) {
            Log.e("Error: " , ex.getMessage());
            throw ex;
        }
    }




}
