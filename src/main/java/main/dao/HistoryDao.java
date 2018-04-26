package main.dao;

import main.models.history.HistoryMultiplayerMessage;
import main.models.history.HistorySingleplayerMessage;

import java.util.List;

public interface HistoryDao {

    List<HistorySingleplayerMessage> getUserHistorySingleplayer(Long id);

    List<HistoryMultiplayerMessage> getUserHistoryMultiplayer(Long id);

}
