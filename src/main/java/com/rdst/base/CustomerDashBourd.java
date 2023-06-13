package com.rdst.base;

import static com.rdst.base.utility.ColorCodes.*;

import java.util.List;
import java.util.Scanner;

import com.rdst.base.dao.CustomerDao;
import com.rdst.base.entity.Customer;
import com.rdst.base.utility.CustomerUtility;

public class CustomerDashBourd {

	public static void customerDashBourd(Scanner scanner)
	{
		char condition;
		do {
			System.out.println("\n" + BackgroundBlack+BrightWhite+"Enter Your Choice...");
			System.out.println(BackgroundBrightBlack + BrightWhite + "--------------------------------");
			System.out.println(BrightYellow + "Press 1 For Add New Customer...");
			System.out.println("Press 2 For Delete Customer...");
			System.out.println("Press 3 For Display Customer By Id...");
			System.out.println("Press 4 For Display All Customer Details...");
			
			Integer choice = scanner.nextInt();
			System.out.println(Reset);
			
			switch (choice) {
			
			case 1:{
				try {
					String message = null;
					Customer customer = CustomerUtility.prepareCustomerDetails();
					if(customer != null) {
						 message = CustomerDao.addNewCustomer(customer);
						if(message.equals("Customer Added Successfully..."))
						{
							System.out.println("\n" + BackgroundBlack+Green+message+Reset+"\n");
						}else {
							System.out.println("\n" + BackgroundBlack+Red+message+Reset+"\n");
						}
					}else {
						System.out.println("\n" + BackgroundBlack+Red+"Customer Not Added..."+Reset+"\n");
					}			
				}catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			
			case 2:{
					List<Customer> allCustomers = CustomerDao.getAllCustomerDetails();
					if(allCustomers != null)
					{
						for (Customer customer : allCustomers) {
							System.out.println(BackgroundBrightBlack + BrightGreen + customer);
						}
						
						System.out.println(Reset);
					}else {
						System.out.println("\n" + BackgroundBrightBlack + BrightRed + "No Records Found... " + "\n" + Reset);
					}
					
					
					System.out.println("\n" + BackgroundBrightBlack + BrightYellow + "Enter Customer Id To Delete...");
					Integer customerId = scanner.nextInt();
					
					System.out.println(Reset);
					
					String message = CustomerDao.deleteCustomerById(customerId);
					if(message.equalsIgnoreCase("Customer Deleted Successfully....")) {
						System.out.println("\n" + BackgroundBrightBlack + BrightGreen + message + "\n" + Reset);
					}else {
						System.out.println("\n" + BackgroundBrightBlack + BrightRed + message + "\n" + Reset);
					}
				
				//Delete Customer...
				break;
			}
			
			case 3:{
					System.out.println(BackgroundBrightBlack + BrightYellow +"Enter Customer Id...");
					Integer customerId = scanner.nextInt();
					System.out.println(Reset);
					
					Customer customer = CustomerDao.getCustomerById(customerId);
					if(customer != null) {
						System.out.println("\n" + BackgroundBrightBlack + BrightGreen + customer + Reset);
					}else {
						System.out.println("\n" + BackgroundBrightBlack + BrightRed + "No Customer Found For Given Id : " + customerId + Reset );
					}
	
				
				//3 For Display Customer By Id...
				break;
			}
			
			case 4:{
				
				List<Customer> listOfCustomers = CustomerDao.getAllCustomerDetails();
				if(listOfCustomers != null) {
					for (Customer customer : listOfCustomers) {
						System.out.println(BackgroundBlack + BrightGreen + customer);
					}
				}else {
					System.out.println("\n" + BackgroundBrightBlack + BrightRed + "No Records Found..." + Reset);
				}
				//Display All Customer Details...
				break;
			}

			default:{
				System.out.println(BackgroundBlack+Red+"Invalid choice..Please Chose correct option..");
				break;
			}
			} // End Switch
			
			System.out.println("\n" + BackgroundBlack+BrightYellow+"Do You Want To Continue...." + "\n" + "Type Yes or No For Main Menu ");
			condition = scanner.next().charAt(0);
			System.out.println(Reset);
			
		} while (condition == 'y' || condition == 'Y');
	}
	
}
