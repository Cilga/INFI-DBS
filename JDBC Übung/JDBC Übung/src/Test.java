import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Test {
	static Connection conn = null;
	static Statement stmt = null;
	public static void main(String[] args) {
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:JDBCÜbung.db");
			System.out.println("Connection zur Datenbank wurde erstellt");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS VORLAGE" + "(id INTEGER not NULL)";
			stmt.execute(sql);
			stmt.close();
			System.out.println("Tabelle wurde erstellt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			String sql2 = "INSERT INTO VORLAGE(id) " +
					"VALUES (1)";
			stmt = conn.createStatement();
			stmt.execute(sql2);
			stmt.close();
			System.out.println("Datensätze wurden in die Tabelle eingefügt");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			String sql3 = "SELECT id FROM VORLAGE";
			stmt = conn.createStatement();
			stmt.execute(sql3);
			System.out.println("Datensätze wurden aus der Tabelle gelesen");
			stmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
