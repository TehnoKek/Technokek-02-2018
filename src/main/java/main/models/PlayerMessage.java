package main.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.dao.MultiplayerDao;
import main.dao.SingleplayerDao;
import main.domain.Singleplayer;
import main.domain.User;

public class PlayerMessage {

    private SingleplayerDao singleplayerDao;
    private MultiplayerDao multiplayerDao;

    private Long id;

    @JsonProperty(value = "nickname")
    private String nickname;

    @JsonProperty(value = "score")
    private int score;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "games_number")
    private int gamesNumber;

    @JsonProperty(value = "avatar")
    private String avatar;

    public PlayerMessage(SingleplayerDao singleplayerDao, MultiplayerDao multiplayerDao, Long id, String nickname, int score, String email, int gamesNumber, String avatar) {
        this.singleplayerDao = singleplayerDao;
        this.multiplayerDao = multiplayerDao;
        this.id = id;
        this.nickname = nickname;
        this.score = score;
        this.email = email;
        this.gamesNumber = gamesNumber;
        this.avatar = avatar;
    }

    public PlayerMessage(UserMessage user) {
        this.id = user.getId();
        this.nickname = user.getLogin();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
        this.score = user.getScore();
        this.gamesNumber = user.getGamesNumber();
    }

    public PlayerMessage(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
        final Singleplayer singleplayer = singleplayerDao.getById(user.getId());
        this.score = singleplayer.getScore().intValue();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public Long getId() {
        return id;
    }

    public int getGamesNumber() {
        return gamesNumber;
    }

    public SingleplayerDao getSingleplayerDao() {
        return singleplayerDao;
    }

    public void setSingleplayerDao(SingleplayerDao singleplayerDao) {
        this.singleplayerDao = singleplayerDao;
    }

    public MultiplayerDao getMultiplayerDao() {
        return multiplayerDao;
    }

    public void setMultiplayerDao(MultiplayerDao multiplayerDao) {
        this.multiplayerDao = multiplayerDao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGamesNumber(int gamesNumber) {
        this.gamesNumber = gamesNumber;
    }
}
