import java.util.Currency;
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

	public static void main(String[] args) {

		GeneralFunction.createDataDir();
		Menu.welcome();
		System.out.print("Your choice: ");
		int choice = CheckInput.toIntNumeric(scanner.nextLine(), 1, 2);
		switch (choice) {
			case 1:
				currentUser = GeneralFunction.login(scanner);
				break;

			case 2:
				currentUser = GeneralFunction.register(scanner);
				break;

			default:
				break;
		}

		if (currentUser instanceof Admin) {
			AdminFunction.AdminManagement(scanner);
		} else if (currentUser instanceof Staff) {
			StaffFunction.StaffManagement((Staff) currentUser, scanner);
		} else if (currentUser instanceof Customer) {
			CustomerFunction.CustomerBuy((Customer) currentUser, scanner);
		}
	}

}
