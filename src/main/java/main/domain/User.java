package main.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	private String nickname;
	private String email;
	private String password;
	private String avatar;

	@Column(name = "games_number")
	private Integer gamesNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getGamesNumber() {
		return gamesNumber;
	}

	public void setGamesNumber(Integer gamesNumber) {
		this.gamesNumber = gamesNumber;
	}
}
