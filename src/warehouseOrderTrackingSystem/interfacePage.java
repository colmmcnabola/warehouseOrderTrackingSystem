package warehouseOrderTrackingSystem;

import java.util.Scanner;

	public final class interfacePage {
		private final arrayOfWarehouseWorkers user;
		private final Scanner scanner;
		
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
				System.out.println("Please choose from the menu below which action you wish to carry out. ");
				System.out.println("1. Check out an order that is being worked on");
				System.out.println("2. Product picked from stock that has been ordered");
				System.out.println("3. Change the status of a particular product");
				System.out.println("4. Purchase Order Arriving");
				System.out.println("5. Find a products location in the warehouse");
				System.out.println("6. List Items that need porous wear and what stock levels are left of it");
				System.out.println("0. Log out:");
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice){
				case 1: 
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 2: 
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 3: 
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 4: 
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 5:
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 6: 
					System.out.println("Please choose the option of which you want to carry out");
					break;
				case 0:
					System.out.println("You have been logged out. See ya lataaaaaaaa ");
				default: 
						System.out.println("Computer Says No.");
			}
		}
		// whenever they have logged in, this is the menu that the warehouse worker has to choose from.
		
		
		
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

