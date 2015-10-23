package warehouseOrderTrackingSystem;

public class customerOrder implements Comparable <customerOrder>{
	// default variables 
		private int customerId; 
		private String customerName;
		private String employeeWorking;
		private String checkedOut;
		
		public customerOrder (int customerId, String customerName, String employeeWorking, String checkedout){
			this.customerId = customerId;
			this.customerName = customerName;
			this.employeeWorking = employeeWorking;
			this.checkedOut = checkedOut;
		}
		
		//Get and set methods
		public int getCustomerId(){
			return customerId;
		}
		
		public void setCustomerId (int orderId){
			this.customerId = customerId;
		}
		
		public String getCustomerName (){
			return customerName;
		}
		
		public void setCustomerName (String customerName){
			this.customerName = customerName;
		}
		
		public String getEmployeeWorking (){
			return employeeWorking;
		}
		
		public void setEmployeeWorking (String employeeWorking){
			this.employeeWorking = employeeWorking;
		}
		
		public String getCheckedOut (){
			return checkedOut;
		}
		
		public void setCheckedOut (String checkedOut){
			this.checkedOut = checkedOut;
		}
		
		
		@Override
		public int compareTo(customerOrder o) {
			// TODO Auto-generated method stub
			return 0;
		}
}
