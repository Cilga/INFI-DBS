import java.util.Date;
public class Ranking {

	private int playerid;
	private int levelid;
	private int points;
	private Date date;
	
	public Ranking(int playerid, int levelid, int points, Date date){
		this.playerid = playerid;
		this.levelid = levelid;
		this.points = points;
		this.date = date;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String toString(){
		return playerid +", "+levelid+", "+points+", "+date;
	}
}
