package main.dao;

import main.domain.HistoryMultiplayer;
import main.domain.User;
import main.mapper.MultiplayerMapper;
import main.mapper.SingleplayerMapper;
import main.models.history.HistoryMultiplayerMessage;
import main.models.history.HistorySingleplayerMessage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HistoryDaoSystem implements HistoryDao {

    private final JdbcTemplate template;
    private UserDaoSystem userDaoSystem;

    public HistoryDaoSystem(JdbcTemplate template, UserDaoSystem userDaoSystem) {
        this.template = template;
        this.userDaoSystem = userDaoSystem;
    }

    @Override
    public List<HistorySingleplayerMessage> getUserHistorySingleplayer(Long id) {
        final String sql = "select date, score from singleplayer where user_id = ?";
        final List<HistorySingleplayerMessage> result = template.query(sql, ps -> ps.setLong(1, id), SingleplayerMapper.SINGLEPLAYER_HISTORY);
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }

    @Override
    public List<HistoryMultiplayerMessage> getUserHistoryMultiplayer(Long id) {
        final String sql = "select * from multiplayer where user_first_id = ? or User_second_id = ?";
        final List<HistoryMultiplayer> result = template.query(sql, ps -> {
            ps.setLong(1, id);
            ps.setLong(2,id);
        }, MultiplayerMapper.MULTIPLAYER_HISTORY);
        if (result.isEmpty()) {
            return null;
        }
        List<HistoryMultiplayerMessage> messages = new ArrayList<>();
        for (HistoryMultiplayer item : result ) {
            if (item.getUser1().equals(id)){
                User currUser = userDaoSystem.getById(item.getUser1());
                HistoryMultiplayerMessage currMess = new HistoryMultiplayerMessage(item.getData(),item.getScore(), currUser.getNickname() );
                messages.add(currMess);
            }
            if (item.getUser2().equals(id)){
                User currUser = userDaoSystem.getById(item.getUser2());
                HistoryMultiplayerMessage currMess = new HistoryMultiplayerMessage(item.getData(),item.getScore(), currUser.getNickname() );
                messages.add(currMess);
            }
        }
        return messages;
    }
}
