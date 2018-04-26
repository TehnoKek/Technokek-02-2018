package main.models.history;

import java.sql.Timestamp;
import java.util.Objects;

public class HistorySingleplayerMessage {

    private Timestamp date;
    private Long score;

    public HistorySingleplayerMessage(Timestamp date, Long score) {
        this.date = date;
        this.score = score;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorySingleplayerMessage that = (HistorySingleplayerMessage) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, score);
    }
}
