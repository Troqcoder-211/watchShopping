package function;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import management.UserManagement;
import user.Admin;
import user.Customer;
import user.User;
import util.CheckInput;
import util.Constant;

public class GeneralFunction {

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void pressAnyKeyToContinue() {
		System.out.println("\nPress Enter key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public static boolean createDataDir() {
		File baseDir = new File(Constant.dataPath.data_BaseDir);
		File billsDir = new File(Constant.dataPath.Bills_Dir);
		File cartsDir = new File(Constant.dataPath.Carts_Dir);
		baseDir.mkdirs();
		billsDir.mkdirs();
		cartsDir.mkdirs();
		GeneralFunction.createFile(Constant.dataPath.accounts_File);
		GeneralFunction.createFile(Constant.dataPath.watches_File);
		return baseDir.exists() && billsDir.exists() && cartsDir.exists();
	}

	public static boolean createFile(String filePath) {
		File file = new File(filePath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			return false;
		}
		return true;

	}

	public static boolean removeFile(String fileName) {
		return new File(fileName).delete();
	}

	public static User login(Scanner scanner) {
		UserManagement accountManagement = new UserManagement(Constant.dataPath.accounts_File);
		System.out.print("Enter your ID(sdt): ");
		String id = scanner.nextLine();
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
		if (id.equals("0988888888") && password.equals("123")) {
			System.out.println("Successfully logged in as admin");
			return new Admin("0988888888", "123", "Admin", "admin");
		}
		User user = accountManagement.findUserById(id);

		if (user != null && user.getPassword().equals(password)) {
			if (user.getRole().equals("customer")) {
				System.out.println("Successfully logged in as customer");

			} else {
				System.out.println("Successfully logged in as staff");
			}
			return user;
		}
		System.out.println("FAIL TO LOGIN");
		return null;
	}

	public static User register(Scanner scanner) {
		UserManagement userManagement = new UserManagement(Constant.dataPath.accounts_File);
		User user = null;
		String id = null;
		String password = null;
		String fullName = null;

		do {
			System.out.print("Enter your ID(sdt): ");
			id = scanner.nextLine();
			id = CheckInput.toPhoneNumber(id);
		} while (id == null);

		System.out.print("Enter your password: ");
		password = scanner.nextLine();

		do {
			System.out.print("Enter your full name: ");
			System.out.println("EX : Nguyen_Van_A");
			fullName = scanner.nextLine();
			fullName = CheckInput.toFullName(fullName);

		} while (fullName == null);

		user = new Customer(id, password, fullName, "3");
		if (userManagement.addUser(user)) {
			System.out.println("REGISTER SUCCESSFULLY");
			return user;
		}
		System.out.println("FAIL TO REGISTER");
		return null;
	}

}
