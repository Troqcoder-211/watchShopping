package function;

import java.util.Scanner;

import management.WatchManagement;
import util.Constant;
import watch.Watches;

public class AdminFunction {
    static WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);

    public static void productManagement(Scanner scanner) {
        switch ("1") {
            case "1":
                viewProduct(watchManagement);
                break;
            case "2":
                addProduct(watchManagement, scanner);
                break;
            default:
                break;
        }
    }

    public static void viewProduct(WatchManagement watchManagement) {

        for (Object watch : watchManagement.getWatchList().getArr()) {
            System.out.println((Watches) watch);
        }
    }

    public static void addProduct(WatchManagement watchManagement, Scanner scanner) {

        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        watchManagement.addWatches(new Watches(id, name, brand, type, price, quantity));
    }

    public static void searchProduct(WatchManagement watchManagement, Scanner scanner) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        for (Object watch : watchManagement.getWatchList().getArr()) {
            if (((Watches) watch).getId().equals(id)) {
                System.out.println((Watches) watch);
            }
        }
    }
}
