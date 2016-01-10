package es.uma.lcc.riatec6.mastermind.dao.interfaces;

import java.util.List;

import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

/**
 * Created by LENOVO on 04/01/2016.
 */
public interface IMasterMindDAO {

    void saveNewRakingRecord(PlayerRecord record);

    List<PlayerRecord> getRankingRecords();
}
