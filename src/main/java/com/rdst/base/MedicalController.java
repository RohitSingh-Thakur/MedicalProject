package com.rdst.base;

import static com.rdst.base.utility.ColorCodes.*; 
import java.util.Scanner;
import com.rdst.base.service.LoginControl;

public class MedicalController {
	public static void main(String args[]) {
		
		try (Scanner scannerMain = new Scanner(System.in);) {
			char c;

			do {
				System.out.println(BackgroundBrightBlack + BrightYellow +"****** Welcome TO Medical Store Project ****** "+ "\n" + "Press Any Key For Login...");
				String choice = scannerMain.next();
				int x = choice.length();
				System.out.println(Reset);

				switch (x) {
				
				case 1: {
					
					String status = LoginControl.loginUser();
					
					if (status.equalsIgnoreCase("Login Successfull...")) {
						
						System.out.println("\n"+BackgroundBlack+Green+status+Reset+"\n");
												
						try {
							
							char condition;
							
							do {
								System.out.println(BackgroundBlack+BrightWhite+"Enter Your Choice...");
								System.out.println(BackgroundBrightBlack + BrightWhite + "--------------------------------");
								System.out.println(BrightYellow + "Press 1 For Medicine DashBourd...");
								System.out.println("Press 2 For Customer DashBourd...");
								System.out.println("Press 3 For User DashBourd...");
														
								int newChoice = scannerMain.nextInt();
								System.out.println(Reset);

								switch (newChoice) 
								{
								case 1:
								{
									MedicineDashBourd.medicineDashBourd(scannerMain);
									break;
								}
								
								case 2: {
									CustomerDashBourd.customerDashBourd(scannerMain);
									break;
								}
								case 3: {
									UserDashBourd.userDashBourd(scannerMain);
									break;
								}

								default:
									System.out.println(BackgroundBrightWhite+Red+"Invalid choice..Please Chose correct option..");
									break;
								}
								
								
								System.out.println("\n" + BackgroundBlack+BrightYellow+"Do You Want To Continue...." + "\n" + "Type [Yes] or [No] For Main Menu ");
								condition = scannerMain.next().charAt(0);
								System.out.println(Reset);
								
								
							} while (condition == 'y' || condition == 'Y');

						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						System.out.println("\n"+BackgroundBlack+Red+status+Reset+"\n");
					}
					break;
				}// End Of Main Case 1
				default: {
					System.out.println(BackgroundBrightWhite+Red+"Invalid choice..Please Chose correct option..");
					break;
				}
				}// End Of Main Switch

				System.out.println(BackgroundBlack+BrightYellow+"Do You Want To Continue...." + "\n" + "Type [Yes] To Continue or [No] To Exit");
				c = scannerMain.next().charAt(0);

			}/*End Of Main Do*/ while (c == 'y' || c == 'Y');

			System.out.println(BackgroundBlack+Red+"App Terminated...");

		}//End OF Main Try
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
