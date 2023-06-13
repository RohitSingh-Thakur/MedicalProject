package com.rdst.base;

import static com.rdst.base.utility.ColorCodes.*; 

import java.util.List;
import java.util.Scanner;

import com.rdst.base.dao.MedicineDao;
import com.rdst.base.entity.Medicine;
import com.rdst.base.utility.MedicineUtility;

public class MedicineDashBourd {
	public static void medicineDashBourd(Scanner scanner) {

		try {

			char condition;

			do {
				System.out.println("\n" + BackgroundBlack+BrightWhite+"Enter Your Choice...");
				System.out.println(BackgroundBrightBlack + BrightWhite + "--------------------------------");
				
				System.out.println(BrightYellow + "Press 1 For Add Medicine...");
				System.out.println("Press 2 For Delete Medicine...");
				System.out.println("Press 3 For Display Medicine By ID...");
				System.out.println("Press 4 For Display All Medicine Details...");
				System.out.println("Press 5 For Update Medicine Details...");
				System.out.println("Press 6 For Change Specific Details...");

				int choice = scanner.nextInt();

				System.out.println(Reset);

				switch (choice) {
				case 1: {
					String message = null;
					Medicine medicineDetails = MedicineUtility.prepareMedicineDetails();

					if (medicineDetails != null) {

						message = MedicineDao.addNewMedicine(medicineDetails);

						if (message.equals("Medicine Added Successfully...")) {
							System.out.println("\n" + BackgroundBlack + Green + message + Reset + "\n");
						} else {
							System.out.println("\n" + BackgroundBlack + Red + message + Reset + "\n");
						}
					}

					break;
				}
				case 2: {
					do {
						List<Medicine> medicines = MedicineDao.getAllMedicinesDetails();
						if(medicines != null) {
							
							for (Medicine medicine : medicines) {
								System.out.println(BackgroundBlack + Green + medicine);
							}
							
						}else {
							System.out.println("\n" + BackgroundBrightWhite+ Red + "No Record Found..." + Reset);
						}
						
						
		
					System.out.println("\n"+BackgroundBlack+ Yellow+ "Press [N] To Go Previous Menu OR Press [Y] To Continue...");
					char c = scanner.next().charAt(0);
					if(c == 'n' || c == 'N') {
						break;
					}if(c == 'y' || c == 'Y') {
						System.out.println("\n"+BackgroundBlack+ Yellow+ "Enter Medicine Id To Delete...");
						Integer medicineId = scanner.nextInt();					
						System.out.println(Reset);
					
										
					String message = MedicineDao.deleteMedicineById(medicineId);
					if(message.equalsIgnoreCase("Medicine Deleted SuccessFully.....")) {
						System.out.println("\n" + BackgroundBlack + BrightGreen + message + Reset);
					}else {
						System.out.println("\n" + BackgroundBrightWhite + BrightRed + message + Reset + "\n");
					}
					
				}else {
					System.out.println("\n" + BackgroundBrightWhite + BrightRed + "Wrong Input : " + c + Reset + "\n");
					
				}
					}while(true);
					
					
					System.out.println(Reset);
					
					//Delete Medicine 

					break;
				}

				case 3: {
					System.out.println(BackgroundBlack+Yellow+"Enter Medicine ID");
					int medicineId = scanner.nextInt();
					System.out.println(Reset);
					Medicine medicine = MedicineDao.getMedicineById(medicineId);
					if(medicine != null) {
						System.out.println(BackgroundBlack + BrightWhite + medicine + Reset);
					}else {
						System.out.println("\n"+BackgroundBrightWhite+Red+ "No Record Found For Given Id : " + medicineId + Reset +"\n");
					}
						// 3 For Display Medicine By ID...
					break;
				}
				case 4: {
					
						List<Medicine> list = MedicineDao.getAllMedicinesDetails();
						if(!list.isEmpty()) {
							for (Medicine medicine : list) {
								System.out.println(BackgroundBlack + Green + medicine + Reset);
							}
							System.out.println();
						}else {
							System.out.println(BackgroundBrightWhite + Red + "No Records Found" + Reset);
						}
						// 4 For Display All Medicine Details...
					break;
				}
				case 5:{
					
					List<Medicine> list = MedicineDao.getAllMedicinesDetails();
					if(list.isEmpty() != true){
						for (Medicine medicine : list) {
							System.out.println(BackgroundBlack + Green + medicine + Reset);
						}
						System.out.println();
					}else {
						System.out.println(BackgroundBrightWhite + Red + "No Records Found" + Reset);
					}
					System.out.println(BackgroundBlack+Yellow+"Enter Medicine ID");
					Integer medicineId = scanner.nextInt();
					System.out.println(Reset);
					String message = MedicineDao.updateMedicicineDetails(medicineId);
					if(message.equals("Medicine Details Updated Sucessfully...")) {
						System.out.println("\n"+BackgroundBlack + Green + message + Reset + "\n");
					}else {
						System.out.println(BackgroundBrightWhite + Red + message + Reset);
					}
					
					break;
				}
				
				
				case 6:{
					
					List<Medicine> list = MedicineDao.getAllMedicinesDetails();
					if(list.isEmpty() != true){
						for (Medicine medicine : list) {
							System.out.println(BackgroundBlack + Green + medicine + Reset);
						}
						System.out.println();
					}else {
						System.out.println(BackgroundBrightWhite + Red + "No Records Found" + Reset);
					}
					
					System.out.println(BackgroundBlack+Yellow+"Enter Medicine ID");
					Integer medicineId = scanner.nextInt();
					System.out.println(Reset);
					
					String message = MedicineDao.updateMedicineSpecificDetails(medicineId);
					if(message.equalsIgnoreCase("Product Name Changed SuccessFully...")) {
						System.out.println("\n"+BackgroundBlack + Green + message + Reset + "\n");
					}else {
						System.out.println("\n" + BackgroundBrightWhite + Red + message + Reset + "\n");
					}
					
					break;
				}
				
				

				default: {
					System.out.println(BackgroundBrightWhite + Red + "Invalid choice..Please Chose correct option..");
					break;
				}

				} // End Switch

				System.out.println(BackgroundBlack + BrightYellow + "Do You Want To Continue...." + "\n"
						+ "Type [Yes] or [No] For Main Menu ");
				condition = scanner.next().charAt(0);
				System.out.println(Reset);

			} while (condition == 'y' || condition == 'Y');

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
