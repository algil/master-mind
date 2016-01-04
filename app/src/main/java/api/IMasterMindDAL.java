package api;

import java.util.List;

import domain.PlayerRecord;

/**
 * Created by LENOVO on 04/01/2016.
 */
public interface IMasterMindDAL {
    void saveNewRakingRecord(PlayerRecord record);

    List<PlayerRecord> getRankingRecords();
}
