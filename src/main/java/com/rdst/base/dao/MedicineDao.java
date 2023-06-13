package com.rdst.base.dao;

import java.util.List; 
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rdst.base.configuration.HibernateConfiguratinProvider;
import com.rdst.base.entity.Medicine;
import com.rdst.base.utility.MedicineUtility;
import com.rdst.base.validation.ValidateMedicine;

import static com.rdst.base.utility.ColorCodes.*;

public class MedicineDao {

	public static String addNewMedicine(Medicine medicine) {
		String message = null;
		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession();) {

			session.save(medicine);
			session.beginTransaction().commit();
			message = "Medicine Added Successfully...";

		} catch (Exception e) {
			e.printStackTrace();
			message = "Medicine Not Added...";
		}
		return message;
	}

	public static List<Medicine> getAllMedicinesDetails() {
		List<Medicine> medicineList = null;
		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			Criteria criteria = session.createCriteria(Medicine.class);
			medicineList = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
			medicineList = null;
		}
		return medicineList;
	}

	public static Medicine getMedicineById(Integer medicineId) {
		Medicine medicine = null;
		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			medicine = session.get(Medicine.class, medicineId);

		} catch (Exception e) {
			e.printStackTrace();
			medicine = null;
		}

		return medicine;
	}

	public static String deleteMedicineById(Integer medicineId) {

		String message = null;

		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			Medicine medicine = session.get(Medicine.class, medicineId);
			if (medicine != null) {
				session.delete(medicine);
				session.beginTransaction().commit();
				message = "Medicine Deleted SuccessFully.....";
			} else {
				message = "No Medicine Found For Given ID : " + medicineId;
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "No Medicine Found For Given ID : " + medicineId;
		}
		return message;
	}

	public static String updateMedicicineDetails(Integer medicineId) {
		String message = null;

		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			Medicine oldMedicine = session.get(Medicine.class, medicineId);

			if (oldMedicine != null) {

				Medicine newMedicine = MedicineUtility.prepareMedicineDetails();

				oldMedicine.setProductName(newMedicine.getProductName());
				oldMedicine.setBatchNumber(newMedicine.getBatchNumber());
				oldMedicine.setQuantity(newMedicine.getQuantity());
				oldMedicine.setManufacturingDate(newMedicine.getManufacturingDate());
				oldMedicine.setExpiryDate(newMedicine.getExpiryDate());
				oldMedicine.setMrp(newMedicine.getMrp());
				oldMedicine.setManufacturedBy(newMedicine.getManufacturedBy());

				session.saveOrUpdate(oldMedicine);
				session.beginTransaction().commit();

				message = "Medicine Details Updated Sucessfully...";

			} else {
				message = "No Record Found For Medicine Id : " + medicineId;
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "Something Went Wrong....";
		}

		return message;
	}

	public static String updateMedicineSpecificDetails(Integer medicineId) {
		String message = null;
	

		try (SessionFactory factory = HibernateConfiguratinProvider.getSessionFactory();
				Session session = factory.openSession()) {

			Medicine oldMedicine = session.get(Medicine.class, medicineId);

			if (oldMedicine != null) {
				char c;
				do {
					System.out.println("\n" + BackgroundBlack + BrightWhite + "Enter Your Choice...");
					System.out.println(BackgroundBrightBlack + BrightWhite + "--------------------------------");

					System.out.println(BrightYellow + "Press 1 For Change ProductName...");
					System.out.println("Press 2 For Change Batch Number...");
					System.out.println("Press 3 For Change Quantity...");
					System.out.println("Press 4 For Change Manufacturing Date...");
					System.out.println("Press 5 For Change Expiry Date...");
					System.out.println("Press 6 For Change MRP...");
					System.out.println("Press 7 For Change Manufactured By...");

					int choice = new Scanner(System.in).nextInt();
					System.out.println(Reset);

					switch (choice) {
					
					case 1: { // For Change ProductName...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Product Name");
						String productName = new Scanner(System.in).next();
						System.out.println(Reset);

						oldMedicine.setProductName(productName);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Product Name Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Product Name..." + Reset);
						}
						break;
					}

					case 2: { // Change Batch Number...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Batch Number");
						String batchNumber = new Scanner(System.in).next();
						System.out.println(Reset);
						
						oldMedicine.setBatchNumber(batchNumber); 

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Batch Number Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Batch Number..." + Reset);
						}

						break;
					}
					
					case 3:{ // For Change Quantity...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Quantity");
						Integer quantity = new Scanner(System.in).nextInt();
						System.out.println(Reset);
						
						oldMedicine.setQuantity(quantity);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Quantity Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Quantity..." + Reset);
						}
						break;
					}
					
					case 4:{ // Change Manufacturing Date...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Manufacturing Date In [dd-MM-yyyy] Format");
						String manufacturingDate = new Scanner(System.in).next();
						System.out.println(Reset);
						
						oldMedicine.setManufacturingDate(manufacturingDate);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Manufacturing Date Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Manufacturing Date..." + Reset);
						}
						break;
					}
					
					case 5:{ // Change Expiry Date...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Expiry Date In [dd-MM-yyyy] Format");
						String expiryDate = new Scanner(System.in).next();
						System.out.println(Reset);
						
						oldMedicine.setExpiryDate(expiryDate);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Expiry Date Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Expiry Date..." + Reset);
						}
						break;
					}
					
					case 6:{ // Change MRP...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter MRP");
						Double mrp = new Scanner(System.in).nextDouble();
						System.out.println(Reset);
						
						oldMedicine.setMrp(mrp);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "MRP Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update MRP..." + Reset);
						}
						break;
					}
					
					case 7:{ // Change Manufactured By...
						System.out.println(BackgroundBrightBlack + BrightYellow + "Enter Manufactured By");
						String manufacturedBy = new Scanner(System.in).next();
						System.out.println(Reset);
						
						oldMedicine.setManufacturedBy(manufacturedBy);

						boolean status = ValidateMedicine.validateMedcine(oldMedicine);

						if (status) {
							session.save(oldMedicine);
							session.beginTransaction().commit();
							System.out.println("\n" + BackgroundBlack + Green + "Manufactured By Changed SuccessFully..."
									+ Reset + "\n");
						} else {
							System.out.println(
									BackgroundBrightWhite + Red + "Unable To Update Manufactured By..." + Reset);
						}
						break;
					}
					
					default: {
						System.out.println(
								BackgroundBrightWhite + Red + "Invalid choice..Please Chose correct option.." + Reset);
						break;
					}

					} // END OF SWITCH
					System.out.println("\n" + BackgroundBlack + BrightYellow + "Do You Want To Continue...." + "\n"
							+ "Type [Yes] or [No] For Exit ");
					c = new Scanner(System.in).next().charAt(0);
				} while (c == 'Y' || c == 'y');

			} else { // END OF MAIN IF
				message = "No Record Found For Given Medicine Id : " + medicineId;
			}

		} catch (Exception e) { // END OF MAIN TRY
			System.out.println(Reset);
			e.printStackTrace();
			message = "Somthing Went Wrong...";
		}
		message = "Select Option";
		return message;
	} // END OF updateMedicineSpecificDetails

}
