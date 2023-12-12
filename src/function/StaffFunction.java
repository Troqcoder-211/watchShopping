package function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import management.BillManagement;
import management.UserManagement;
import management.WatchManagement;
import user.Staff;
import util.CheckInput;
import util.Constant;
import util.Menu;
import watch.Watches;

public class StaffFunction {
	static UserManagement userManagement = new UserManagement(Constant.dataPath.accounts_File);

	public static boolean StaffManagement(Staff staff, Scanner scanner) {
		WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);
		Menu.staff();
		String choice;
		System.out.print("Enter your choice: ");
		choice = CheckInput.toStrNumberic(scanner.nextLine(), 1, 2);
		if (choice == null)
			return true;
		switch (choice) {
		case "1":
			viewProduct(watchManagement);
			break;
		case "2":
			viewBills(staff, scanner);
			break;
		}
		return false;
	}

	public static void viewProduct(WatchManagement watchManagement) {
		for (Object watch : watchManagement.getWatchList().getArr()) {
			System.out.println((Watches) watch);
		}
	}

	public static void viewBills(Staff staff, Scanner scanner) {
		listFileInDir(Constant.dataPath.Bills_Dir);
		System.out.println("View details of bill: ");
		System.out.print("Enter id: ");
		String id = scanner.nextLine();
		if (!displayContent(Constant.dataPath.Bills_Dir + id)) {
			System.out.println("Bill does not exist");
		} else {
			System.out.println("Verify bill[y/n]: ");
			if (CheckInput.toYesNo(scanner.nextLine())) {
				BillManagement billManagement = new BillManagement(Constant.dataPath.Bills_Dir, id);
				billManagement.VerifyBill(staff.getId());
			}
		}
	}

	public static boolean displayContent(String fileName) {
		try {
			final File file = new File(fileName);
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					System.out.println(data);
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	public static boolean listFileInDir(String path) {
		final File folder = new File(path);
		if (folder.list() == null)
			return false;
		for (final String fileEntry : folder.list()) {
			System.out.println(fileEntry);
		}
		return true;
	}

}
