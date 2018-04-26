package main.mapper;

import main.domain.HistoryMultiplayer;
import main.domain.Multiplayer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;

public class MultiplayerMapper {
    public static final RowMapper<Multiplayer> MULTIPLAYER_MAPPER = (res, num) -> {
        Long id = res.getLong("game_id");
        Long score = res.getLong("score");
        Long userIdFirst = res.getLong("user_first_id");
        Long userIdSecond = res.getLong("user_second_id");

        return new Multiplayer(id, userIdFirst, userIdSecond, score);
    };

    public static final RowMapper<HistoryMultiplayer> MULTIPLAYER_HISTORY = (res, num) -> {
        Long gameId = res.getLong("game_id");
        Long user1 = res.getLong("user_first_id");
        Long user2 = res.getLong("user_second_id");
        Long score = res.getLong("score");
        Timestamp date = res.getTimestamp("date");

        return new HistoryMultiplayer(gameId,user1,user2,score,date);
    };
}
