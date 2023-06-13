package com.rdst.base.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rdst.base.entity.Medicine;
import com.rdst.base.validation.ValidateMedicine;

import static com.rdst.base.utility.ColorCodes.*;
public class MedicineUtility {
	
	public static Medicine prepareMedicineDetails()
	{
		Medicine medicine = null;
		try {
			System.out.println(BackgroundBrightBlack+BrightYellow+"Please Fill Medicine Details");
			System.out.println("--------------------------------");
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter Product Name");
			String productName = scanner.next();
			
			System.out.println("Enter Batch Number");
			String batchNumber = scanner.next();
			
			System.out.println("Enter Quantity");
			Integer quantity = scanner.nextInt();
			
			System.out.println("Enter Manufacturing Date In [dd-MM-yyyy] Format");
			String manufacturingDate = scanner.next();
			
			System.out.println("Enter Expiry Date In [dd-MM-yyyy] Format");
			String expiryDate = scanner.next();
			
			System.out.println("Enter MRP");
			Double mrp = scanner.nextDouble();
			
			System.out.println("Enter Manufactured By");
			String manufacturedBy = scanner.next();
			
			System.out.println(Reset);
			
			medicine = new Medicine(quantity, productName, batchNumber, quantity, manufacturingDate, expiryDate, mrp, manufacturedBy);
			
			boolean validateMedcine = ValidateMedicine.validateMedcine(medicine);
			if(validateMedcine)
			{
				return medicine;
			}else {
				medicine = null;
			}
			
		}catch (InputMismatchException e) {
			System.out.println(Reset);
			System.out.println("\n" + BackgroundBrightWhite + BrightRed + "Invalid Input...." + Reset + "\n");
		}
		
		catch (Exception e ) {
			System.out.println(Reset);
			e.printStackTrace();
		}
		return medicine;
		
	}

}
