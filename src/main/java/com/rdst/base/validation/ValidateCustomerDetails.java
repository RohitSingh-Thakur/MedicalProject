package com.rdst.base.validation;

import static com.rdst.base.utility.ColorCodes.BackgroundBlack;
import static com.rdst.base.utility.ColorCodes.Red;
import static com.rdst.base.utility.ColorCodes.Reset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rdst.base.entity.Customer;

public class ValidateCustomerDetails {

	public static boolean validateCustomerDetails(Customer customer) {
		boolean state = true;

		if (customer.getCustomerName() != null && customer.getCustomerName().length() > 2) {
			String regex = ".*\\d.*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customer.getCustomerName());
			boolean matches = matcher.matches();
			if (matches) {
				state = false;
				System.out.println(BackgroundBlack + Red + "Please Enter Charachters For UserName." + "\n"
						+ " Digits Are Not Allowed...." + Reset);
				//return state;
			}
		} else {
			System.out.println(BackgroundBlack + Red + "Customer Name To Short... " + Reset);
			state = false;
			//return state;
		}

		if (customer.getCustomerAge() != null && customer.getCustomerAge().length() > 0
				&& customer.getCustomerAge().length() <= 2) {

			boolean age = customer.getCustomerAge().matches("[0-9]+");
			if (age) {
				state = true;
			} else {
				System.out.println(BackgroundBlack + Red + "Enter Digits For Age... " + Reset);
				state = false;
				//return state;
			}
		}else {
			System.out.println(BackgroundBlack + Red + "Enter Valid aget... " + Reset);
			state = false;
			//return state;
		}
		
		if(customer.getGender() != null && customer.getGender().length() > 0 && customer.getGender().length() <= 6) {
			String regex = ".*\\d.*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customer.getGender());
			boolean matches = matcher.matches();
			if (matches) {
				state = false;
				System.out.println(BackgroundBlack + Red + "Please Enter Charachters For Gender." + "\n"
						+ " Digits Are Not Allowed...." + Reset);
				return state;
			}
			
		}else {
			System.out.println(BackgroundBlack + Red + "Please Fill Gender [male/female]... " + Reset);
			state = false;
			//return state;
		}
		
		if(customer.getMobileNumber() != null) {
			
			String regex = "\\d{10}";
			boolean matches = customer.getMobileNumber().matches(regex);
			if (matches) {
				state= true;
			} else {
				System.out.println(BackgroundBlack+Red+"Please Enter 10 Digit Number ...." + Reset);
				state = false;
			}
			
		}else {
			state = false;
			System.out.println(BackgroundBlack+Red+"Invalid Mobile Number ...." + Reset);
			//return state;
		}

		if(customer.getState() != null && customer.getState().length()>1) {
			String regex = ".*\\d.*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customer.getState());
			boolean matches = matcher.matches();
			if (matches) {
				state = false;
				System.out.println(BackgroundBlack + Red + "Please Enter Charachters For State." + "\n"
						+ " Digits Are Not Allowed...." + Reset);
				//return state;
			}
		}else {
			System.out.println(BackgroundBlack + Red + "State Name Invalid... " + Reset);
			state = false;
			//return state;
		}

		if(customer.getFess() != null && customer.getFess() > 0) {
			state = true;

		}else {
			System.out.println(BackgroundBlack + Red + "Enter Amount... " + Reset);
			state = false;
		}
		
		return state;
	}

}
