public class Player {
	
	private int playerid;
	private String username;
	private String password;
	private String email;
	
	public Player(int playerid, String username, String password, String email){
		this.playerid = playerid;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		return playerid+", "+username+", "+password+", "+email;
	}
}
