public class Level {

	private int levelid;
	private String description;
	
	public Level(int levelid,String description){
		this.levelid = levelid;
		this.description = description;
	}

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String toString(){
		return levelid+", "+description;
	}
}
