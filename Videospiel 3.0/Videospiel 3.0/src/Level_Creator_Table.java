
public class Level_Creator_Table {

	private int playerid;
	private int levelid;
	private int isMainCreator;
	
	public Level_Creator_Table(int playerid, int levelid, int isMainCreator){
		this.playerid = playerid;
		this.levelid = levelid;
		this.isMainCreator = isMainCreator;
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

	public int getIsMainCreator() {
		return isMainCreator;
	}

	public void setIsMainCreator(int isMainCreator) {
		this.isMainCreator = isMainCreator;
	}
	
	public String toString(){
		return playerid+", "+levelid+", "+isMainCreator;
	}
	
}
