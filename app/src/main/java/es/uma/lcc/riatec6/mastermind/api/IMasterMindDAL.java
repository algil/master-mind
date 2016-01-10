package es.uma.lcc.riatec6.mastermind.api;

import java.util.List;

import es.uma.lcc.riatec6.mastermind.domain.PlayerRecord;

/**
 * Created by LENOVO on 04/01/2016.
 */
public interface IMasterMindDAL {
    void saveNewRakingRecord(PlayerRecord record);

    List<PlayerRecord> getRankingRecords();
}
