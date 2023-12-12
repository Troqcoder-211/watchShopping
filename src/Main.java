import java.util.Scanner;

import function.AdminFunction;
import function.CustomerFunction;
import function.GeneralFunction;
import function.StaffFunction;
import user.Admin;
import user.Customer;
import user.Staff;
import user.User;
import util.CheckInput;
import util.Menu;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static User currentUser = null;
	static boolean loginSession = true;

	public static void main(String[] args) {

		if (!GeneralFunction.createDataDir()) {
			System.out.println("Fail to generate data folder");
			return;
		}

		do {
			GeneralFunction.clearScreen();
			Menu.welcome();

			System.out.print("Your choice: ");

			int choice = CheckInput.toIntNumeric(scanner.nextLine(), 1, 2);
			switch (choice) {
				case 1:
					currentUser = GeneralFunction.login(scanner);
					GeneralFunction.pressAnyKeyToContinue(scanner);
					break;

				case 2:
					currentUser = GeneralFunction.register(scanner);
					GeneralFunction.pressAnyKeyToContinue(scanner);
					break;

				default:
					System.out.println("Exiting...");
					loginSession = false;
					currentUser = null;
			}

			while (currentUser != null) {
				GeneralFunction.clearScreen();
				if (currentUser instanceof Admin) {
					if (AdminFunction.AdminManagement(scanner))
						break;
				} else if (currentUser instanceof Staff) {
					if (StaffFunction.StaffManagement((Staff) currentUser, scanner))
						break;
				} else if (currentUser instanceof Customer) {
					if (CustomerFunction.CustomerBuy((Customer) currentUser, scanner))
						break;
				}

				System.out.println();
				GeneralFunction.pressAnyKeyToContinue(scanner);
			}
		} while (loginSession);
	}

}
