package com.rdst.base.service;

import java.util.Scanner; 

import com.rdst.base.dao.DataBaseDao;
import static com.rdst.base.utility.ColorCodes.*;
public class LoginControl {
	
	public static String loginUser()
	{
		String status = null;
		try 
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.println(BackgroundBlack+BrightYellow+"Enter UserName...");
			String userName = scanner.next();
			
			System.out.println(BrightYellow+"Enter Password...");
			String password = scanner.next();
			System.out.println(Reset);
			
			status = DataBaseDao.loginController(userName, password);
			return status;
			
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}
	}

}
