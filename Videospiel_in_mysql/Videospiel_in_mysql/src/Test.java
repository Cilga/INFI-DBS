import java.sql.*;
import java.util.Scanner;

public class Test {
	static Connection conn = null;
	static Statement stmt = null;
	static String sql = null;
	
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Videospiel?user=root");
			System.out.println("Connection zur Datenbank wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS PLAYER1" 
					+ "(playerid INT NOT NULL,"
					+ "username TEXT NOT NULL,"
					+ "password TEXT NOT NULL," 
					+ "email TEXT NOT NULL,"
					+ "PRIMARY KEY(playerid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Player wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS LEVEL1" 
					+ "(levelid INT NOT NULL," 
					+ "creator TEXT NOT NULL," 
					+ "description TEXT NOT NULL,"
					+ "PRIMARY KEY(levelid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Level wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS RANKING1" 
					+ "(points INT NOT NULL," 
					+ "date DATE NOT NULL," 
					+ "levelid INT NOT NULL,"  
					+ "playerid INT NOT NULL,"
					+ "PRIMARY KEY(points),"
					+ "FOREIGN KEY (levelid) REFERENCES LEVEL1(levelid),"
					+ "FOREIGN KEY (playerid) REFERENCES PLAYER1(playerid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Ranking wurde erstellt");
			stmt = conn.createStatement();
			sql = "CREATE TABLE IF NOT EXISTS LEVELCREATOR" 
					+ "(playerid INT NOT NULL," 
					+ "levelid INT NOT NULL," 
					+ "isMainCreator INT NOT NULL,"  
					+ "FOREIGN KEY (levelid) REFERENCES LEVEL1(levelid),"
					+ "FOREIGN KEY (playerid) REFERENCES PLAYER1(playerid)"
					+ ");";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle Level-Creator wurde erstellt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		insertIntoTable();
		selectFromTable();
		/*		try{
			sql = "UPDATE PLAYER1 SET playerid = 13, "
					+ "username = 'cilgaa',"
					+ "password = 'cilgaa',"
					+ "email = 'cilga@live.tr',"
					+ "WHERE playerid = 1;";
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datensätze der Tabelle Player wurden aktualisiert");
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}*/
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertIntoTable(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("a....Player");
		System.out.println("b....Level");
		System.out.println("c....Ranking");
		System.out.println("d....LevelCreator");
		System.out.println("In welche Tabelle soll eingefügt werden?:");

		while(scanner.hasNextLine()) {
			String eingabe = scanner.next();
			if(eingabe.equals("a")){
				try {
					sql = "INSERT INTO PLAYER1(playerid, username, password, email) " +
							"VALUES (2, 'cil', 'cilgus', 'cilga@gmx.com');";

					stmt.execute(sql);
					stmt.close();
					System.out.println("Datensätze wurden in die Tabelle Player eingefügt");
				}catch(SQLException e){}		
			}
			if(eingabe.equals("b")){
				try {
					sql = "INSERT INTO LEVEL1(levelid, creator, description) " +
							"VALUES (13, 'cilga', 'hammerhart');";
					stmt = conn.createStatement();
					stmt.execute(sql);
					stmt.close();
					System.out.println("Datensätze wurden in die Tabelle Level eingefügt");
				}catch(SQLException e){}		
			}
			if(eingabe.equals("c")){
				try {
					sql = "INSERT INTO RANKING1(points, date, levelid, playerid) " +
							"VALUES (9001, 08-04-1998, 13, 2);";
					stmt = conn.createStatement();
					stmt.execute(sql);
					stmt.close();
					System.out.println("Datensätze wurden in die Tabelle Player eingefügt");
				}catch(SQLException e){}		
			}
			if(!eingabe.equals("a") && !eingabe.equals("b") && !eingabe.equals("c") && !eingabe.equals("d")){
				System.out.println("Falsche Eingabe wurde getätigt");
				scanner.close();
				return;
			}
		}
		scanner.close();
	}
	
	public static void selectFromTable(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("a....Player");
		System.out.println("b....Level");
		System.out.println("c....Ranking");
		System.out.println("d....LevelCreator");
		System.out.println("Aus welcher Tabelle sollen die Daten angezeigt werden?:");

		while(scanner.hasNextLine()) {
			String eingabe = scanner.next();
			if(eingabe.equals("a")){
				try{
					sql = "SELECT * FROM PLAYER1;";
					stmt = conn.createStatement();
					stmt.execute(sql);
					System.out.println("Datensätze wurden aus der Tabelle Player gelesen");
					stmt.close();
				}
				catch(SQLException e){	
				}
			}
			if(eingabe.equals("b")){
				try{
					sql = "SELECT * FROM LEVEL1;";
					stmt = conn.createStatement();
					stmt.execute(sql);
					System.out.println("Datensätze wurden aus der Tabelle Level gelesen");
					stmt.close();
				}
				catch(SQLException e){	
				}
			}
			if(eingabe.equals("c")){
				try{
					sql = "SELECT * FROM RANKING1;";
					stmt = conn.createStatement();
					stmt.execute(sql);
					System.out.println("Datensätze wurden aus der Tabelle Ranking gelesen");
					stmt.close();
				}
				catch(SQLException e){	
				}
			}
			if(eingabe.equals("d")){
				try{
					sql = "SELECT * FROM LEVELCREATOR;";
					stmt = conn.createStatement();
					stmt.execute(sql);
					System.out.println("Datensätze wurden aus der Tabelle LevelCreator gelesen");
					stmt.close();
				}
				catch(SQLException e){	
				}
			}
			if(!eingabe.equals("a") && !eingabe.equals("b") && !eingabe.equals("c") && !eingabe.equals("d")){
				System.out.println("Falsche Eingabe wurde geteatigt");
				scanner.close();
				return;
			}
		}
		scanner.close();
	}
}