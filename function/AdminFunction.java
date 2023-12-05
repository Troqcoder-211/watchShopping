package function;

import java.util.Scanner;

import management.BillManagement;
import management.UserManagement;
import management.WatchManagement;
import user.User;
import util.Constant;
import util.Menu;
import watch.Watches;

public class AdminFunction {
    static WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);
    static UserManagement userManagement = new UserManagement(Constant.dataPath.accounts_File);

    public static void AdmintManagement(Scanner scanner) {
        Menu.admin();
        String choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        } while (choice != "1" && choice == "2" && choice == "0");
        switch (choice) {
            case "1":
                Menu.product();
                productManagement(scanner);
                break;
            case "2":
                Menu.account();
                accountManagement(scanner);
                break;
            case "0":
                break;
            default:
                break;
        }
    }

    public static void productManagement(Scanner scanner) {
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                viewProduct(watchManagement);
                break;
            case "2":
                addProduct(watchManagement, scanner);
            case "3":
                searchProduct(watchManagement, scanner);
            case "0":
                break;
            default:
                break;
        }
    }

    public static void accountManagement(Scanner scanner) {
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                deleteAccount(userManagement, scanner);
                break;
            case "2":
                searchAccount(scanner);
            case "0":
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

    public static void deleteAccount(UserManagement userManagement, Scanner scanner) {
        for (Object user : userManagement.getAcclist().getArr()) {
            System.out.println((User) user);
        }
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        userManagement.removeUser(id);

    }

    public static void searchAccount(Scanner scanner) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        for (Object user : userManagement.getAcclist().getArr()) {
            if (((User) user).getId().equals(id)) {
                System.out.println((User) user);
            }
        }
    }

}
