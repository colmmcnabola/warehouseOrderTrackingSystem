package warehouseOrderTrackingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class databaseConnection {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/warehourseordertrackingsystem";
	static final String USER = "root";
	static final String PASS = "colm1990";
	
	Statement stmt = null;
	Connection conn = getConnection();
	
	//connecting to the database
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

	//printing of the product table of the product
	public void readFromDatabaseProduct (){
		try{
		System.out.println("Creating statement..");
		stmt = conn.createStatement();
		String sql2 = " SELECT idproduct, productname, productdesc, productloc, productquantremain FROM product";
		ResultSet rs = stmt.executeQuery(sql2);
		while(rs.next()){
		int idproduct = rs.getInt("idproduct");
		String productname = rs.getString("productname");
		String productdesc = rs.getString("productdesc");
		String productloc = rs.getString("productloc");
		int productquantremain = rs.getInt("productquantremain");
		System.out.println("Product I.D " + idproduct + ". Product Name:" + productname + ". Product description: " + productdesc +". Product Location: " +productloc + " . Product Quantity Remaining: " + productquantremain + "."); 
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
	
	//arraylist calling al of the products table.
	public ArrayList<Product> readAllProducts (){
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		String ReadProductInfo = "SELECT * FROM product ";
		ResultSet rsProductInfo; 
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsProductInfo = stmt.executeQuery(ReadProductInfo);
			while(rsProductInfo.next()){
			Product product = new Product(0, ReadProductInfo, ReadProductInfo, ReadProductInfo, 0);
			
			int PID = rsProductInfo.getInt("orderid");
			String PNM = rsProductInfo.getString("productname");
			String PDS = rsProductInfo.getString("productdesc");
			String PLO = rsProductInfo.getString("productloc");
			int PRO = rsProductInfo.getInt("productquantremain");	
			
			listOfProducts.add(product);
		} rsProductInfo.close();
		return listOfProducts;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//arraylist with all of the purchase orders table called
	public ArrayList<purchaseOrder> readAllPurchaseOrders (){
		ArrayList<purchaseOrder> listOfPurchaseOrders = new ArrayList<purchaseOrder>();
		String readPurchase = "SELECT * FROM purchaseorder";
		getConnection();
		ResultSet rsPurchase;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsPurchase= stmt.executeQuery(readPurchase);
		while (rsPurchase.next()){
			purchaseOrder po = new purchaseOrder(0, readPurchase, readPurchase, readPurchase);
		
			int PID = rsPurchase.getInt("purchaseorderid");
			String PON = rsPurchase.getString("purchaseordername");
			String EW = rsPurchase.getString("employeeworking");
			String CO = rsPurchase.getString("checkedout");
		
			po.setPurchaseOrderId(PID);
			po.setPurchaseOrderName(PON);
			po.setEmployeeWorking(EW);
			po.setCheckedOut(CO);
		
			listOfPurchaseOrders.add(po);
		}
		rsPurchase.close();
		return listOfPurchaseOrders;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//array list with all of the purchase order line called. 
	public ArrayList<purchaseOrderLine> readAllPurchaseOrderLine (){
		ArrayList<purchaseOrderLine> listOfPurchaseOrderLine = new ArrayList <purchaseOrderLine>();
		String readPurchaseOrderLine = "SELECT * FROM purchaseOrderLine";
		getConnection();
		ResultSet rsPurchaseOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsPurchaseOrderLine = stmt.executeQuery(readPurchaseOrderLine);
		while (rsPurchaseOrderLine.next()){
			purchaseOrderLine pol = new purchaseOrderLine(0, readPurchaseOrderLine, 0);
			
			int POLID = rsPurchaseOrderLine.getInt("purchaseorderlineid");
			String PN = rsPurchaseOrderLine.getString("productname");
			int Q = rsPurchaseOrderLine.getInt("quantity");
			
			pol.setPurchaseOrderLineId(POLID);
			pol.setProductName(PN);
			pol.setQuantity(Q);
			
			listOfPurchaseOrderLine.add(pol);
		}
		rsPurchaseOrderLine.close();
		return listOfPurchaseOrderLine;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//arraylist with all of the details from the customer order line table. 
	public ArrayList<customerOrder> readAllCustomerOrders(){
		ArrayList<customerOrder> listOfCustomerOrders = new ArrayList<customerOrder>();
		String readCustomer = "SELECT * FROM customerorder";
		getConnection();
		ResultSet rsCustomer;
		try{ 
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomer= stmt.executeQuery(readCustomer);
		while (rsCustomer.next()){
			customerOrder co = new customerOrder (0, readCustomer, readCustomer, readCustomer);
			
			int CID = rsCustomer.getInt("customerid");
			String CN = rsCustomer.getString("customername");
			String EW = rsCustomer.getString("employeeworking");
			String CO = rsCustomer.getString("checkedout");
			
			co.setCustomerId(CID);
			co.setCustomerName(CN);
			co.setEmployeeWorking(EW);
			co.setCheckedOut(CO);
			
			listOfCustomerOrders.add(co);
		}
		rsCustomer.close();
		return listOfCustomerOrders;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	//ArrayList with all of the customer order details entered.
	public ArrayList<customerOrderLine> readAllCustomerOrderLine(){
		ArrayList<customerOrderLine> listOfCustomerOrderLine = new ArrayList<customerOrderLine>();
		String readCustomerOrderLine = "SELECT * FROM customerorderline";
		getConnection();
		ResultSet rsCustomerOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomerOrderLine= stmt.executeQuery(readCustomerOrderLine);
		while (rsCustomerOrderLine.next()){
			customerOrderLine col = new customerOrderLine(0, readCustomerOrderLine, 0);
			
			int CID = rsCustomerOrderLine.getInt("customerid");
			String PN = rsCustomerOrderLine.getString("productname");
			int Q = rsCustomerOrderLine.getInt("quantity");
			
			col.setCustomerId(CID);
			col.setProductName(PN);
			col.setQuantity(Q);
			
			listOfCustomerOrderLine.add(col);
		}
		rsCustomerOrderLine.close();
		return listOfCustomerOrderLine;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//ArrayList with just the productId from the customer order line table
	public ArrayList<customerOrderLine> readAllCustomerOrderLine(int productId){
		ArrayList<customerOrderLine> listOfCustomerOrderLine = new ArrayList<customerOrderLine>();
		String readCustomerOrderLine = "SELECT * FROM customerorderline";
		getConnection();
		ResultSet rsCustomerOrderLine;
		try{
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			rsCustomerOrderLine= stmt.executeQuery(readCustomerOrderLine);
		while (rsCustomerOrderLine.next()){
			customerOrderLine col = new customerOrderLine(0, readCustomerOrderLine, 0);
			
			int CID = rsCustomerOrderLine.getInt("customerid");
			String PN = rsCustomerOrderLine.getString("productname");
			int Q = rsCustomerOrderLine.getInt("quantity");
			
			col.setCustomerId(CID);
			col.setProductName(PN);
			col.setQuantity(Q);
			
			listOfCustomerOrderLine.add(col);
		}
		rsCustomerOrderLine.close();
		return listOfCustomerOrderLine;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	//deleting a customer order from products
	public void deleteCustomerOrderFromProducts(){
		try{
		System.out.println("Creating Statement ... ");
		stmt = conn.createStatement();
		String sql4 = "DELETE FROM product" + "WHERE orderid =";
		stmt.executeUpdate(sql4);
		}
		catch (SQLException sqle) {
		 sqle.printStackTrace();
		} catch (Exception e) {
		 e.printStackTrace();
		} finally {
		 try {
		  if (stmt != null)
		   stmt.close();
		  } catch (SQLException se) { }
		  try {
		   if (conn != null)
		    conn.close();
		   } catch (SQLException se) {
		    se.printStackTrace();
		   }
		  }
		  System.out.println("Goodbye!");
	}
	
	//Linking to the database and reading the order line table
	public void readFromDatabaseOrderline (){
		try{
			System.out.println("Creating statement..");
			stmt = conn.createStatement();
			String sql2 = " SELECT orderid, productid, quantity FROM orderline";
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()){
			int orderid = rs.getInt("orderid");
			int productid = rs.getInt("productid");
			int quantity= rs.getInt("quantity");
			System.out.println("Order ID " + orderid + ". Product ID" + productid + ". Quantity: " + quantity); 
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
	
	//creating a record into the orderline table in the database 	
	public void createDatabaseOrderLine (){
		try{
		System.out.println("Inserting Records Into The dase .... ");
		stmt = conn.createStatement();
		String sql = "INSERT INTO orderLine " + "VALUES (6, 10, 5)";
		stmt.executeUpdate(sql);
		System.out.println("Inserted Records Into Table ... ");
		} catch (SQLException sqle) {
		 sqle.printStackTrace();
		} catch (Exception e) {
		 e.printStackTrace();
		} finally {
		 try {
		  if (stmt != null)
		   stmt.close();
		  } catch (SQLException se) { }
		  try {
		   if (conn != null)
		    conn.close();
		   } catch (SQLException se) {
		    se.printStackTrace();
		   }
		  }
		  System.out.println("Goodbye!");
		 } 
}
	
	


