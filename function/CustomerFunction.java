package function;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import bill.Bill;
import management.WatchManagement;
import util.CheckInput;
import util.Constant;
import util.Menu;
import watch.Watches;
import user.Customer;

public class CustomerFunction {

    static WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);

    public static Bill CustomerBuy(Customer customer, Scanner scanner) {
        WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);

        Menu.customer();
        displayWatchlist(watchManagement);
        System.out.print("Enter id product you want to buy: ");
        String id = scanner.nextLine();
        int index;
        if ((index = watchManagement.getWatchList().findIndex(id)) != -1) {

            int quantity = ((Watches) watchManagement.getWatchList().get(index)).getQuantity();

            String strQuanti;
            do {
                System.out.print("Enter quantity you want to buy: ");
                strQuanti = CheckInput.toStrNumberic(id, 1, quantity);
                if (strQuanti == null) {
                    System.out.println("Please enter quantity again, because quantity not enough");
                }
            } while (strQuanti == null);
            int quantityToBuy = Integer.parseInt(strQuanti);
            String currentDate = new SimpleDateFormat("dd-MM-yyyy-h:m:s").format(new java.util.Date());
            Watches tmp = (Watches) watchManagement.getWatchList().get(index);
            return new Bill(customer.getId(), tmp.getId(), tmp.getName(), quantityToBuy, currentDate,
                    (quantityToBuy * tmp.getPrice()));
        }

        return null;
    }

    public static void displayWatchlist(WatchManagement watchManagement) {
        for (Object watch : watchManagement.getWatchList().getArr()) {
            System.out.println((Watches) watch);
        }
    }
}
