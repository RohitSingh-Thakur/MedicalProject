package com.rdst.base.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rdst.base.entity.User;
import static com.rdst.base.utility.ColorCodes.*;
public class ValidateUser {

	public static boolean validateUser(User user) {

		boolean b = true;

		if (user.getUserName().length() > 1 && user.getUserName().length() < 100) {
			String regex = ".*\\d.*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(user.getUserName());
			boolean matches = matcher.matches();
			if (matches) {
				b = false;
				System.out.println(BackgroundBlack+Red+"Please Enter Charachters For UserName...." + Reset);
				return b;
			}
		} else {
			b = false;
			System.out.println(BackgroundBlack+Red+"UserName Too Short...." + Reset);
			return b;
		}

		if (user.getPassword().length() > 1 && user.getPassword().length() < 100) {
			b = true;
		} else {
			b = false;
			System.out.println(BackgroundBlack+Red+"Password To Short...." + Reset);
			return b;
		}

		if (user.getEmailId().length() > 1 && user.getEmailId().length() < 100) {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(user.getEmailId());
			b = matcher.find();

			if (b) {
				b = true;
			}else {
				System.out.println(BackgroundBlack+Red+"Please Enter Valid Email Id ...." + Reset);
				b = false;
				return b;
			}
		} else {
			b = false;
			System.out.println(BackgroundBlack+Red+"Enter Complete Email Id ...." + Reset);
			return b;
		}

		if (user.getMobileNumber() != null) {

			String regex = "\\d{10}";
			boolean matches = user.getMobileNumber().matches(regex);
			if (matches) {
				return b;
			} else {
				System.out.println(BackgroundBlack+Red+"Please Enter 10 Digit Number ...." + Reset);
				b = false;
			}
		} else {
			b = false;
			System.out.println(BackgroundBlack+Red+"Invalid Mobile Number ...." + Reset);
			return b;
		}

		return b;

	}
}
