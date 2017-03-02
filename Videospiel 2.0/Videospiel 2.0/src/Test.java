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
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\HTL\\5.Klasse\\INFI-DBP\\Videospiel 2.0\\Videospiel 2.0\\Videospiel.db");
			System.out.println("Connection zur Datenbank wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS PLAYER1" 
					+ "(playerid INT PRIMARY KEY NOT NULL,"
					+ "username TEXT NOT NULL,"
					+ "password TEXT NOT NULL," 
					+ "email TEXT NOT NULL"
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
					+ "(points INT PRIMARY KEY NOT NULL," 
					+ "date DATE NOT NULL," 
					+ "levelid INT NOT NULL,"  
					+ "playerid INT NOT NULL,"
					+ "FOREIGN KEY (levelid) REFERENCES LEVEL(levelid),"
					+ "FOREIGN KEY (playerid) REFERENCES PLAYER(playerid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Ranking wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS LEVELCREATOR" 
					+ "(playerid INT NOT NULL," 
					+ "levelid INT NOT NULL," 
					+ "isMainCreator INT NOT NULL,"  
					+ "FOREIGN KEY (levelid) REFERENCES LEVEL(levelid),"
					+ "FOREIGN KEY (playerid) REFERENCES PLAYER(playerid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Level-Creator wurde erstellt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			sql = "INSERT INTO PLAYER1(playerid, username, password, email) " +
					"VALUES (2, 'cil', 'cilgus', 'cilga@gmx.com');";
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
			sql = "INSERT INTO RANKING1(points, date, levelid, playerid) " +
					"VALUES (9001, 08-04-1998, 13, 2);";
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle Ranking eingefügt");
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			sql = "INSERT INTO LEVELCREATOR(playerid, levelid, isMainCreator) " +
					"VALUES (2, 13, 1);";
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle Level-Creator eingefügt");
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
			sql = "SELECT * FROM LEVELCREATOR;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze wurden aus der Tabelle Level-Creator gelesen");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			sql = "UPDATE PLAYER1 SET playerid = 13, "
					+ "username = 'cilgaa',"
					+ "password = 'cilgaa', email = 'cilga@live.tr'"
					+ "WHERE playerid = 1;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze der Tabelle Player wurden aktualisiert");
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
	public static void createTable(){}
	public static void insertIntoTable(){}
	public static void selectFromTable(){}
	public static void updateInTable(){}
}
