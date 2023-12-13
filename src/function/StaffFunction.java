package function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import management.BillManagement;
import management.UserManagement;
import management.WatchManagement;
import user.Staff;
import util.ChangeFormat;
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
				displayWatchlist(watchManagement);
				break;
			case "2":
				viewBills(staff, scanner);
				break;
		}
		return false;
	}

	public static void displayWatchlist(WatchManagement watchManagement) {
		System.out.format("%-10s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Brand", "Type", "Price", "Quantity");
		for (Object watch : watchManagement.getWatchList().getArr()) {
			System.out.format("%-10s%-20s%-20s%-20s%-20s%-20d\n",
					((Watches) watch).getId(),
					((Watches) watch).getName(),
					((Watches) watch).getBrand(),
					((Watches) watch).getType(),
					ChangeFormat.priceFormat(((Watches) watch).getPrice()),
					((Watches) watch).getQuantity());

		}
	}

	public static void viewBills(Staff staff, Scanner scanner) {
		listFileInDir(Constant.dataPath.Bills_Dir);
		System.out.println("View details of bill: ");
		String id;
		System.out.print("Enter id: ");
		id = scanner.nextLine();
		while (!displayContent(Constant.dataPath.Bills_Dir + id)){
			System.out.println("Bill not found");
			System.out.print("Enter id: ");
			id = scanner.nextLine();
		}
		
		System.out.println("Verify bill[y/n]: ");
		if (CheckInput.toYesNo(scanner.nextLine())) {
			BillManagement billManagement = new BillManagement(Constant.dataPath.Bills_Dir, id);
			billManagement.VerifyBill(staff.getId());

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
