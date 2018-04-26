package main.mapper;

import main.domain.Singleplayer;
import main.models.history.HistorySingleplayerMessage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;

public class SingleplayerMapper {

    public static final RowMapper<Singleplayer> SINGLEPLAYER_MAPPER = (res, num) -> {
        Long id = res.getLong("game_id");
        Long score = res.getLong("score");
        Long userId = res.getLong("user_id");

        return new Singleplayer(id, userId, score);
    };

    public static final RowMapper<HistorySingleplayerMessage> SINGLEPLAYER_HISTORY = (res, num) -> {
        Long score = res.getLong("score");
        Timestamp date = res.getTimestamp("date");

       return new HistorySingleplayerMessage(date,score);
    };
}
