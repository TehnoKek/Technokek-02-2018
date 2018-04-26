package main.models.history;

import java.sql.Timestamp;
import java.util.Objects;

public class HistoryMultiplayerMessage {

    private Timestamp date;
    private Long score;
    private String partner;

    public HistoryMultiplayerMessage(Timestamp date, Long score, String partner) {
        this.date = date;
        this.score = score;
        this.partner = partner;
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

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryMultiplayerMessage that = (HistoryMultiplayerMessage) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(score, that.score) &&
                Objects.equals(partner, that.partner);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, score, partner);
    }
}
