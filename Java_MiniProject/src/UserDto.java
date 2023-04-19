

public class UserDto {
	
	private String id;
	private String pw;
	private String nick;
	
	public UserDto(String InputId, String InputPw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String InputId) {
		this.id = InputId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String InputPw) {
		this.pw = InputPw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


}
