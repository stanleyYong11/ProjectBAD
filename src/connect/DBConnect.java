package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {

	private final String USER = "root";
	private final String PASSWORD = "";
	private final String HOST = "localhost:3306";
	private final String DATABASE = "jdbc";
	
	private final String URL = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	private Connection connection;
	private Statement statement;
	
	static DBConnect dbConnect;
	
	private DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBConnect getInstance() {
		if(dbConnect == null) {
			return dbConnect = new DBConnect();
		}
		return dbConnect;
	}
	
	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
