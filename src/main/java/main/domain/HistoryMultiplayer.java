package main.domain;


import java.sql.Timestamp;
import java.util.Objects;

public class HistoryMultiplayer {

    private Long gameId;
    private Long user1;
    private Long user2;
    private Long score;
    private Timestamp data;

    public HistoryMultiplayer(Long gameId, Long user1, Long user2, Long score, Timestamp data) {
        this.gameId = gameId;
        this.user1 = user1;
        this.user2 = user2;
        this.score = score;
        this.data = data;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getUser1() {
        return user1;
    }

    public void setUser1(Long user1) {
        this.user1 = user1;
    }

    public Long getUser2() {
        return user2;
    }

    public void setUser2(Long user2) {
        this.user2 = user2;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryMultiplayer that = (HistoryMultiplayer) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(user1, that.user1) &&
                Objects.equals(user2, that.user2) &&
                Objects.equals(score, that.score) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameId, user1, user2, score, data);
    }
}
