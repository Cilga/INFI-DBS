import java.sql.*;
public class Test {
	static Connection conn = null;
	static Statement stmt = null;
	static String sql = null;
	public static void main(String[] args){
		try{
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){}
		try{
			conn = DriverManager.getConnection("jdbc:sqlite:Videospiel.db");
			System.out.println("Connection zur Datenbank wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS PLAYER1" 
					+ "(username TEXT PRIMARY KEY NOT NULL,"
					+ "password TEXT NOT NULL," 
					+ "e-mail TEXT NOT NULL"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Player wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS LEVEL1" 
					+ "(levelid INT PRIMARY KEY NOT NULL," 
					+ "creator TEXT NOT NULL," 
					+ "description TEXT NOT NULL"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Level wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS RANKING1" 
					+ "(points INT NOT NULL," 
					+ "date DATE NOT NULL," 
					+ "levelid INT NOT NULL,"  
					+ "username TEXT NOT NULL,"
					+ "FOREIGN KEY (levelid) REFERENCES LEVEL(levelid),"
					+ "FOREIGN KEY (username REFERENCES PLAYER(username)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Ranking wurde erstellt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			sql = "INSERT INTO PLAYER1(username, password, e-mail) " +
					"VALUES ('cilga', 'cilgus', 'cilga@gmx.com');";
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle Player eingefügt");
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			sql = "INSERT INTO LEVEL1(levelid, creator, description) " +
					"VALUES (13, 'cilga', 'hammerhart');";
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle Level eingefügt");
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			sql = "INSERT INTO RANKING1(points, date, levelid, username) " +
					"VALUES (9001, 08-04-1998, 13, 'cilga');";
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle Ranking eingefügt");
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			sql = "SELECT * FROM PLAYER1;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze wurden aus der Tabelle Player gelesen");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();	
		}
		try{
			sql = "SELECT * FROM LEVEL1;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze wurden aus der Tabelle Level gelesen");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			sql = "SELECT * FROM RANKING1;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze wurden aus der Tabelle Ranking gelesen");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			sql = "UPDATE PLAYER SET username = 'cilgaa',"
					+ " password = 'cilgaa', e-mail = 'cilga@live.tr'"
					+ "WHERE username = 'cilga';";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze wurden aus der Tabelle Ranking gelesen");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
