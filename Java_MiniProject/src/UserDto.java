

public class UserDto {
	
	private String id;
	private String pw;
	private String nick;
	private int rank;
	
	public UserDto(String id, String pw, String nick, int rank) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.rank = rank;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	

	
}
