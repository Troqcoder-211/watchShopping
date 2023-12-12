package function;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import bill.Bill;
import management.BillManagement;
import management.WatchManagement;
import user.Customer;
import util.CheckInput;
import util.Constant;
import util.Menu;
import watch.Watches;

public class CustomerFunction {

	static WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);

	public static boolean CustomerBuy(Customer customer, Scanner scanner) {
		WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);

		Menu.customer();
		displayWatchlist(watchManagement);
		System.out.print("Enter id product you want to buy (or leave blank to logout): ");
		String id = scanner.nextLine();
		if (id.equals("")) {
			return true;
		}
		int index;
		if ((index = watchManagement.getWatchList().findIndex(id)) != -1) {

			int quantity = ((Watches) watchManagement.getWatchList().get(index)).getQuantity();

			String strQuanti;
			do {
				System.out.print("Enter quantity you want to buy: ");
				strQuanti = CheckInput.toStrNumberic(scanner.nextLine(), 1, quantity);
				if (strQuanti == null) {
					System.out.println("Please enter quantity again, because quantity not enough");
				}
			} while (strQuanti == null);
			int quantityToBuy = Integer.parseInt(strQuanti);
			String currentDate = new SimpleDateFormat("dd-MM-yyyy-h-m-s").format(new java.util.Date());
			Watches tmp = (Watches) watchManagement.getWatchList().get(index);
			Bill newBill = new Bill(customer.getId(), tmp.getId(), tmp.getName(), quantityToBuy, currentDate,
					(quantityToBuy * tmp.getPrice()));
			BillManagement billManagement = new BillManagement(Constant.dataPath.Bills_Dir, currentDate);
			if (billManagement.addBill(newBill)) {
				System.out.println("Bill added successfully");
			} else
				System.out.println("Order error. Please contact technical department for support");
		}

		return false;
	}

	public static void displayWatchlist(WatchManagement watchManagement) {
		System.out.format("%-10s%-20s%-10s%-10s%-20s%-20s\n", "ID", "Name", "Brand", "Type", "Price", "Quantity");
		for (Object watch : watchManagement.getWatchList().getArr()) {
			System.out.format("%-10s%-20s%-10s%-10s%-20f%-20d\n",
					((Watches) watch).getId(),
					((Watches) watch).getName(),
					((Watches) watch).getBrand(),
					((Watches) watch).getType(),
					((Watches) watch).getPrice(),
					((Watches) watch).getQuantity());
		}
	}
}
