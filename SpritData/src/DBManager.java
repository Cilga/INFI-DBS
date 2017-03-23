import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBManager{

	static Connection conn = null;
	static Statement stmt = null;
	static String sql = null;
	static ResultSet rs = null;
	static int anzahlTankstellen;

	public static void connect(){

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:sprit.db");

		} catch (Exception e){
			e.printStackTrace();
		}	
	}

	public static int setTankstellenanzahl(){

		try {
			stmt = conn.createStatement();
			sql = "SELECT MAX(tankenr) FROM sprit_data;";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				anzahlTankstellen = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return anzahlTankstellen;
	}

	public static ArrayList<Long> getLetzesJahrUTS(){

		ArrayList<Long> a = new ArrayList<Long>();
		long b = 0;

		try {
			stmt = conn.createStatement();
			sql = "SELECT MAX(datum) FROM sprit_data;";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				a.add(rs.getLong(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		b = 365*24*60*60; //365 Tage in Millisekunden

		a.add(a.get(0)-b);

		return a;
	}
	
	public static ArrayList<Long> getLetzeStundeUTS(){

		ArrayList<Long> a = new ArrayList<Long>();
		long b = 0;

		try {
			stmt = conn.createStatement();
			sql = "SELECT MAX(datum) FROM sprit_data;";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				a.add(rs.getLong(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		b = 24*60*60; //1 Tag in Millisekunden

		a.add(a.get(0)-b);

		return a;
	}

	public static ArrayList<ArrayList> durchnittspreisProTagY(){

		ArrayList<ArrayList> durchnittspreiseProTag = new ArrayList<ArrayList>();

		for(int i = 0; i < setTankstellenanzahl(); i++){

			ArrayList<Double> a = new ArrayList<Double>();
			durchnittspreiseProTag.add(a);

		}	

		for(int i = 0 ; i < setTankstellenanzahl(); i++){

			try {

				stmt = conn.createStatement();

				sql = "SELECT AVG(value),date (datum,'unixepoch') FROM sprit_data WHERE datum <= "+getLetzesJahrUTS().get(0)+" AND"
						+ " datum >= "+getLetzesJahrUTS().get(1)+" AND tankenr = "+(i+1)+" AND value != 0 "
						+ "GROUP BY date(datum,'unixepoch');";

				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next())
				{
					durchnittspreiseProTag.get(i).add(rs.getDouble(1));
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}	
		}

		return durchnittspreiseProTag;
	}
	
	public static ArrayList<ArrayList> durchnittspreisProTagX(){

		ArrayList<ArrayList> durchnittspreiseProTag = new ArrayList<ArrayList>();

		for(int i = 0; i < setTankstellenanzahl(); i++){

			ArrayList<Double> a = new ArrayList<Double>();
			durchnittspreiseProTag.add(a);

		}	

		for(int i = 0 ; i < setTankstellenanzahl(); i++){

			try {

				stmt = conn.createStatement();

				sql = "SELECT AVG(value),datum FROM sprit_data WHERE "
						+ "datum <= "+getLetzesJahrUTS().get(0)+" AND"
						+ " datum >= "+getLetzesJahrUTS().get(1)+" AND tankenr = "+(i+1)+" AND value != 0 "
						+ "GROUP BY date(datum,'unixepoch');";

				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next())
				{
					durchnittspreiseProTag.get(i).add(rs.getDouble(2));
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}		
		}

		return durchnittspreiseProTag;
	}
	
	public static ArrayList<Double> günstigteTankstelle(){
		
		ArrayList<Double> a = new ArrayList<Double>();
		
		try{
		
		stmt = conn.createStatement();
		
		sql = "SELECT MIN(value), datum FROM sprit_data WHERE "
				+ "datum <= "+getLetzeStundeUTS().get(0)+" AND "
						+ "datum >= "+getLetzeStundeUTS().get(1)+" GROUP BY strftime('%H',datum, 'unixepoch')";
		
		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next())
		{
			a.add(rs.getDouble(1));
		}

	} catch (SQLException e) {

		e.printStackTrace();
	}	
		return a;
	}
}
