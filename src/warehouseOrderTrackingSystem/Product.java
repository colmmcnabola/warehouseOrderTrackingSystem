package warehouseOrderTrackingSystem;

public class Product implements Comparable <Product> {
	
	//Default Variables of the product
	private int idproduct;
	private String productName;
	private String productDesc;
	private String productLoc;
	private int productQuantRemain;
	
	//Default constructor for a new product
	public Product (int idproduct, String productName, String productDesc, String productLoc, int productQuantRemain){
		this.idproduct = idproduct;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productLoc = productLoc;
		this.productQuantRemain = productQuantRemain;
	}
	
	//Get and Set Methods
	public int getIdproduct (){
		return idproduct;
	}
	
	public void setIdProduct (int idproduct){
		this.idproduct = idproduct;
	}
	
	public String getProductName (){
		return productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductDesc (){
		return productDesc;
	}
	
	public void setProductDesc(String productDesc){
		this.productName = productDesc;
	}
	
	public String getProductLoc (){
		return productLoc;
	}
	
	public void setProductLoc(String productLoc){
		this.productName = productLoc;
	}
	
	public int getProductQuantRemain (){
		return productQuantRemain;
	}
	
	public void setProductQuantRemain(String productQuantRemain){
		this.productName = productQuantRemain;
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
