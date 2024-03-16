package app.dto;

public class SessionDto {
	private long id;
	private String username;
	private String userRoll;

	public SessionDto(long id, String username, String userRoll) {
		this.id = id;
		this.username = username;
		this.userRoll = userRoll;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}
}
