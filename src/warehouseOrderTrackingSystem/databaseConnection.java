package warehouseOrderTrackingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/warehourseordertrackingsystem";
	static final String USER = "root";
	static final String PASS = "colm1990";
	
	Statement stmt = null;
	Connection conn = getConnection();
	
	private Connection getConnection (){
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName ("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database ....");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}
			catch (Exception e){
			System.out.println("Connection failed");
			}
			
			return conn;
	}

	public void readFromDatabaseProduct (){
		try{
		System.out.println("Creating statement..");
		stmt = conn.createStatement();
		String sql2 = " SELECT idproduct, productname, productdesc, productcost, productloc, productquantremain, porouswearrequired FROM product";
		ResultSet rs = stmt.executeQuery(sql2);
		while(rs.next()){
		int idproduct = rs.getInt("idproduct");
		String productname = rs.getString("productname");
		String productdesc = rs.getString("productdesc");
		int productcost = rs.getInt("productcost");
		String productloc = rs.getString("productloc");
		int productquantremain = rs.getInt("productquantremain");
		String porouswearrequired = rs.getString("porouswearrequired");
		System.out.println("Product I.D " + idproduct + ". Product Name:" + productname + "Product description: " + productdesc +". Product Cost: " + "£"+productcost + ". Product Location: " +productloc + ". Product Quantity Remaining: " + productquantremain + "Porous Wear Required: " + porouswearrequired); 
		}
		rs.close();
		conn.close();
	}
	catch (SQLException sqle){
	sqle.printStackTrace();
	}
	catch (Exception e){
	e.printStackTrace();
	}
	}
	
}