package com.rdst.base.utility;
import static com.rdst.base.utility.ColorCodes.*;

import java.util.Scanner;


import com.rdst.base.validation.ValidateCustomerDetails;
import com.rdst.base.entity.Customer;

public class CustomerUtility {
	
	public static Customer prepareCustomerDetails()
	{
		Customer customer = null;
		
		try {
			
			System.out.println(BackgroundBlack);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println(BrightYellow+"Enter Customer Name");
			String customerName = scanner.next();
			
			System.out.println(BrightYellow+"Enter Customer Age");
			String customerAge = scanner.next();
			
			System.out.println(BrightYellow+"Enter Gender [m or f]");
			String gender = scanner.next();
			
			System.out.println(BrightYellow+"Enter Mobile Number");
			String mobileNumber = scanner.next();
			
			System.out.println(BrightYellow+"Customer Problem");
			String problem = scanner.next();
			
			System.out.println(BrightYellow+"Enter State");
			String state = scanner.next();
			
			System.out.println(BrightYellow+"Enter Address");
			String address = scanner.next();
			
			System.out.println(BrightYellow+"Enter Fees");
			Integer fees = scanner.nextInt();
			
			customer = new Customer(fees, customerName, customerAge, gender, mobileNumber, problem, state, address, fees);
			
			System.out.println(Reset);
			boolean validatedCustomer = ValidateCustomerDetails.validateCustomerDetails(customer);
			if(validatedCustomer) {
				return customer;
			}else {
				return null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
