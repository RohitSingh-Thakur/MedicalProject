package com.rdst.base.utility;

import java.util.Scanner;

import com.rdst.base.entity.User;
import com.rdst.base.validation.ValidateUser;
import static com.rdst.base.utility.ColorCodes.*;
public class UserUtility 
{
	
	public static User prepareUserDetails()
	{
		User user = null;

		try 
		{
			System.out.println(BackgroundBlack+BrightYellow);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Please Enter UserName");
			String userName = scanner.next();
			
			System.out.println("Please Enter Password");
			String password = scanner.next();
			
			System.out.println("Please Enter Email Id");
			String emailId = scanner.next();
			
			System.out.println("Please Enter Mobile Number");
			String mobileNumber = scanner.next();
			
			user = new User(null, userName, password, emailId, mobileNumber);
			
			boolean validateUser = ValidateUser.validateUser(user);
			
			if(validateUser) {
				return user;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			System.out.println(Reset);
			e.printStackTrace();
		}
		
		return user;
	}
}
