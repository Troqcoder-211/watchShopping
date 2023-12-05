import java.util.Scanner;

import function.GeneralFunction;
import util.Menu;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		GeneralFunction.createDataDir();
		Menu.welcome();
		int choice;
		do {
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			if (choice == 1 || choice == 2) {
				break;
			}
		} while (true);
		switch (choice) {
			case 1:
				if (GeneralFunction.login(scanner) == null) {
				}
				break;
			case 2:
				GeneralFunction.register(scanner);
				break;
		}
	}

}
