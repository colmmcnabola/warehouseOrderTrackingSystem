package warehouseOrderTrackingSystem;

import java.util.Scanner;

	public final class interfacePage {
		private final arrayOfWarehouseWorkers user;
		private final Scanner scanner;
		databaseConnection dbconnect = new databaseConnection();
		
		public interfacePage (){
			this.user = new arrayOfWarehouseWorkers(10);
			this.scanner = new Scanner (System.in);
			System.out.println ("Welcome to the Warehouse Order Tracking System");
		}
		
		
		public void startMenu (){
			int choice;
			do{
				System.out.println("1. Log In");
				System.out.println("2. Register");
				System.out.println("3. Exit the system.");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice){
				case 0:
					System.out.println("You have now exited the Warehouse Order Tracker System");
					break;
				case 1: 
					loginPrompt();
					break;
				case 2: 
					registerPrompt();
					break;
				default: 
					System.out.println("Wrong Input please try again");
				}
			}while (choice !=0);
		}// Home page switch statements. log in/register/exit.
		
		
		private void loginPrompt(){
			System.out.println("Please enter your username: ");
			String username = scanner.nextLine();
			System.out.println("Please enter your password: ");
			String password = scanner.nextLine();
			
			warehouseWorkerDetails w = login (username, password);
			if ( w != null){
				System.out.println("Computer Says No. Wrong username or password entered.");
			}
			else{
				userMenu(w);
			}
		}//the process of when a user chooses the login option on the home screen. 
		
		private void registerPrompt(){
			System.out.println("We need the following details from you.");
			System.out.println("Your username please: ");
			String username = scanner.nextLine();
			//go back to the register prompt method in SN and look up searching an email thats on the system. 
			System.out.println("Your password please: ");
			String password = scanner.nextLine();
			System.out.println("Your firstname please: ");
			String firstname = scanner.nextLine();
			System.out.println("Your lastname please: ");
			String lastname = scanner.nextLine();
			
			register( new warehouseWorkerDetails (username, password, firstname, lastname));
		}//the process of when a user chooses the register option on the home screen. 
		
		public void register (warehouseWorkerDetails w){
			if (user.getIndexByUsername(w.getUsername ()) == -1)
				user.insert(w);	
		}//register method for the registerPrompt method of the login/register/home screen
		
		private void userMenu (warehouseWorkerDetails w){
			int choice;
			do{
				System.out.println("Please choose from the menu below which action you wish to carry out. ");
			
			System.out.println("1. Inventory Menu");
			System.out.println("2. Order Line Menu");
			System.out.println("3. Customer Order Menu");
			System.out.println("4. Update Order Status");
			System.out.println("5. List Items that need porous wear and what stock levels are left of it");
			System.out.println("0. Log out:");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice){
			case 1: 
				inventoryMenu();
				break;
			case 2: 
				orderLineMenu();
				break;
			case 3: 
				customerOrdermenu();
				break;
			case 4: 
				updateOrderStatus();
				break;
			case 5:
				porousWearRequiredProducts();
				break;
			case 0:
				System.out.println("You have been logged out. See ya lataaaaaaaa ");
			default: 
					System.out.println("Computer Says No.");
		}
		}while (choice !=0);
	}
		// whenever they have logged in, this is the menu that the warehouse worker has to choose from.
		
		private void inventoryMenu() {
			int choice; 
			do{
				System.out.println("--- INVENTORY MENU ---");
			
			System.out.println("1. View Inventory");
			System.out.println("2. Delete Product");	
			System.out.println("3. Update Product information");
			System.out.println("4. Back to main menu");
		
			choice = Integer.parseInt(scanner.nextLine()); 
			switch (choice){
				case 1:
				dbconnect.readFromDatabaseProduct();
				break;
				case 2:
				break;
				case 3:
				break;


				
				case 5: System.out.println("You have now been returned to the user menu");
				userMenu(null);
				return;
				default: 
					System.out.println("Computer Says No.");
			}
			}while (choice !=0);
		}
		
		// Order Line Menu upon selection from the userMenu 
		private void orderLineMenu(){
			int choice;	
			do{
			System.out.println("--- ORDER LINE MENU ---");
			System.out.println("1. View Order Line Menu");
			System.out.println("2. Back to main menu");
			choice = Integer.parseInt(scanner.nextLine()); 
			switch (choice) {
			case 1: 
				System.out.println("ORDER LINE MENU CURRENTLY BEING DEVELOPED");
			break;
			case 2: 
				System.out.println("Exiting back to main menu...");
			userMenu(null);
			break;
			default: 
				System.out.println("Computer Says No.");
			}		
			}while (choice !=0);
		}
		
		// Update order menu from the userMenu class 
		private void updateOrderStatus (){
			int choice;	
			do{
			System.out.println("--- UPDATE ORDER STATUS ---");
			choice = Integer.parseInt(scanner.nextLine()); 
			switch (choice) {
			case 1:
				System.out.println("PROCESSING...");
			break;
			case 2:
				System.out.println("PROCESSING...");
			break;
			case 3: 
				System.out.println("PROCESSING...");
			break;
			case 4:
				System.out.println("PROCESSING...");
			break;
			case 5: 
				System.out.println("Exiting back to main menu...");
			userMenu(null);
			default: 
				System.out.println("Computer Says No.");
			return;
			}	
			}while (choice !=0);
		}
		
		
		// customer order menu from the user menu class
		private void customerOrdermenu (){
			int choice;
			do{
				System.out.println("--- CUSTOMER ORDERS MENU ---");	
				System.out.println("1. View Customer Order");
				System.out.println("2. Create Customer Order");
				System.out.println("3. Delete Customer Order");	
				System.out.println("4. Update Customer Order");				
				System.out.println("5. Back to main menu");
				
				choice = Integer.parseInt(scanner.nextLine()); 
				switch (choice) {
				case 1: 
					
				break;
				case 2:
					System.out.println("PROCESSING...");
				break;
				case 3:
					System.out.println("PROCESSING...");
				break;
				case 4:
					System.out.println("PROCESSING...");
				break;
				case 5:
					System.out.println("Exiting back to main menu...");
					userMenu(null);
					return;
				} 
			}while (choice !=0);
		}
		
		//pororus wear requried products. will be a simple class. connects to the database
		//and just print out what products need the pororus or not. 
		private void porousWearRequiredProducts(){
			int choice;
				do{
				System.out.println("--- POROUS WEAR REQUIRED PRODUCTS ---");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice){
				case 1: 
				userMenu(null);
				break;
				}
			}while (choice !=0);
		}
				
		public warehouseWorkerDetails login (String username, String pass){
			int index = user.getIndexByUsername(username);
			if (index ==-1)
				return null;
			warehouseWorkerDetails w = user.getWarehouseWorkersByIndex(index);
			if (w != null){
				if (w.getUsername().equals(pass)){
					return w;
				}
				else {
					return null;
				}
			}
			return null;
		}// Log in check details based on its password being correct
		
		
	}

