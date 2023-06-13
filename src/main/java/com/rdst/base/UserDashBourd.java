package com.rdst.base;

import static com.rdst.base.utility.ColorCodes.*;
import java.util.List;
import java.util.Scanner;
import com.rdst.base.dao.UserDao;
import com.rdst.base.entity.User;
import com.rdst.base.utility.UserUtility;

public class UserDashBourd {

	public static void userDashBourd(Scanner scanner) {

		char condition;

		try {

			do {

				System.out.println("\n" + BackgroundBlack+BrightWhite+"Enter Your Choice...");
				System.out.println(BackgroundBrightBlack + BrightWhite + "--------------------------------");
				System.out.println(BrightYellow + "Press 1 For Add New User...");
				System.out.println("Press 2 For Delete User...");
				System.out.println("Press 3 For User Details By ID...");
				System.out.println("Press 4 For Display All Users...");
				

				Integer choice = scanner.nextInt();
				System.out.println(Reset);

				switch (choice) {

				case 1: { // For Add New User...
					User prepareUserDetails = UserUtility.prepareUserDetails();
					if (prepareUserDetails != null) {
						String message = UserDao.addNewUser(prepareUserDetails);
						if (message.equals("Record Stored Successfully....")) {
							System.out.println(BackgroundBlack + Green + message + Reset);
						} else {
							System.out.println(BackgroundBlack + Red + message + Reset);
						}
					} else {
						System.out.println(BackgroundBlack + Red + "Fill Correct Details" + Reset);
					}
					break;
				}

				case 2: { // Delete User 
					List<User> usersDetails = UserDao.getUsersDetails();
					if (usersDetails != null) {
						for (User user : usersDetails) {
							System.out.println(BackgroundBlack + Red + user + Reset);
						}
					} else {
						System.out.println(BackgroundBlack + Red + "No Records Found" + Reset);
					}
					
					
					System.out.println(BackgroundBlack + BrightYellow + "Enter User Id To Delete");
					Integer userId = scanner.nextInt();
					System.out.println(Reset);
					
					String message = UserDao.deleteUserDetails(userId);
					if (message.equalsIgnoreCase("User Details Deleted..")) {
						System.out.println(BackgroundBlack + BrightYellow + message + Reset);
					}else {
						System.out.println("\n" + BackgroundBrightBlack + BrightRed + message + Reset + "\n");
					}

					break;
				}

				case 3: { // User Details By ID.

					System.out.println(BackgroundBlack+BrightYellow+"Enter UserID To Display Details");
					int userID = scanner.nextInt();
					System.out.println(Reset);
					
					User user = UserDao.getUserById(userID);
					if(user != null) {
						System.out.println("\n"+BackgroundBlack+BrightWhite+user+Reset + "\n");
					}else {
						System.out.println(BackgroundBlack+Red+"No User Found For Given ID..."+Reset);
					}
					break;
				}
				
				case 4: { // Display All Users..."

					List<User> usersDetails = UserDao.getUsersDetails();
					if (usersDetails != null) {
						for (User user : usersDetails) {
							System.out.println(BackgroundBlack + BrightWhite + user + Reset);
						}
					} else {
						System.out.println(BackgroundBlack + Red + "No Records Found" + Reset);
					}
					break;
				}

				default: {
					break;
				}

				}// End Switch

				System.out.println("\n" + BackgroundBlack + BrightYellow + "Do You Want To Continue...." + "\n"
						+ "Type Yes or No For Main Menu ");
				condition = scanner.next().charAt(0);
				System.out.println(Reset);

			} while (condition == 'y' || condition == 'Y');

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
