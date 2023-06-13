package com.rdst.base.validation;

import com.rdst.base.entity.Medicine;
import static com.rdst.base.utility.ColorCodes.*;

public class ValidateMedicine {

	public static boolean validateMedcine(Medicine medicine) {

		boolean status = true;

		if (medicine.getProductName() != null && medicine.getProductName().length() >= 2) {
			status = true;
		} else {
			System.out.println(BackgroundBrightWhite + Red + "Please Enter Valid Medicine Name... " + Reset + "\n");
			return status = false;
		}

		if (medicine.getBatchNumber() != null && medicine.getBatchNumber().length() >= 2) {
			status = true;
		} else {
			System.out.println(BackgroundBrightWhite + Red + "Batch Number is Too Short... " + Reset + "\n");
			return status = false;
		}

		if (medicine.getManufacturingDate() != null && medicine.getManufacturingDate().length() > 1
				&& medicine.getManufacturingDate().length() == 10) {
			status = true;
		} else {
			System.out.println(BackgroundBrightWhite + Red + "Manufacturing Date Is Not Valid... " + "\n"
					+ "Please Enter Date In Given Format [dd-MM-yyyy] Format" + "\n" + Reset);
			return status = false;
		}

		if (medicine.getMrp() != null && medicine.getMrp() > 0) {
			status = true;
		} else {
			System.out.println(BackgroundBrightWhite + Red + "Enter Valid MRP... " + "\n" + Reset + "\n");
			return status = false;
		}

		if (medicine.getQuantity() != null && medicine.getQuantity() > 0) {
			 status = true;
		}else {
			System.out.println(BackgroundBrightWhite + Red + "Quantity Should Not Be 0... " + "\n" + Reset + "\n");
			return status = false;
		}
		
		if (medicine.getExpiryDate() != null && medicine.getExpiryDate().length() > 1
				&& medicine.getExpiryDate().length() == 10) {
			status = true;
		} else {
			System.out.println(BackgroundBrightWhite + Red + "Expiry Date Is Not Valid... " + "\n"
					+ "Please Enter Date In Given Format [dd-MM-yyyy] Format" + "\n" + Reset);
			return status = false;
		}
		
		return status;

	}
}
