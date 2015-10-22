package warehouseOrderTrackingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class databaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/wots";
	static final String USER = "root";
	static final String PASS = "netbuilder";

	private Connection getConnection (){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName ("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database ....");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}
			catch (Exception e){
			System.out.println("Connection failed"};
			}
	}
	

}
