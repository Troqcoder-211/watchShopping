package function;

import java.util.Scanner;

import management.BillManagement;
import management.UserManagement;
import management.WatchManagement;
import user.Customer;
import user.Staff;
import user.User;
import util.CheckInput;
import util.Constant;
import util.Menu;
import watch.Watches;

public class AdminFunction {
    static WatchManagement watchManagement = new WatchManagement(Constant.dataPath.watches_File);
    static UserManagement userManagement = new UserManagement(Constant.dataPath.accounts_File);

    public static void AdminManagement(Scanner scanner) {
        Menu.admin();
        String choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        } while (CheckInput.toStrNumberic(choice, 1, 2) == null);
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
        viewProduct(watchManagement);
        String choice;
        do {
            System.out.print("Enter your choice[1-3]: ");
            choice = scanner.nextLine();
        } while (CheckInput.toStrNumberic(choice, 1, 3) == null);
        switch (choice) {
            case "1":
                addProduct(watchManagement, scanner);
                break;
            case "2":
                editProduct(watchManagement, scanner);
                break;
            case "3":
                deleteProduct(watchManagement, scanner);
            case "4":
                searchProduct(watchManagement, scanner);
                break;
            default:
                break;
        }
    }

    public static void accountManagement(Scanner scanner) {
        String choice;
        do {
            System.out.print("Enter your choice[1-3]: ");
            choice = scanner.nextLine();
        } while (CheckInput.toStrNumberic(choice, 1, 3) == null);

        switch (choice) {
            case "1":
                deleteAccount(userManagement, scanner);
                break;
            case "2":

                searchAccount(userManagement, scanner);
            case "3":
                addStaff(userManagement, scanner);
                break;
            case "4":
                blockCustomer(userManagement, scanner);
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
        displayUserlist(userManagement);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        userManagement.removeUser(id);

    }

    public static void searchAccount(UserManagement userManagement, Scanner scanner) {
        displayUserlist(userManagement);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        for (Object user : userManagement.getAcclist().getArr()) {
            if (((User) user).getFullName().contains(name)) {
                System.out.println((User) user);
            }
        }
    }

    public static void displayUserlist(UserManagement userManagement) {
        for (Object user : userManagement.getAcclist().getArr()) {
            System.out.println((User) user);
        }
    }

    public static void displayWatchlist(WatchManagement watchManagement) {
        for (Object watch : watchManagement.getWatchList().getArr()) {
            System.out.println((Watches) watch);
        }
    }

    public static void addStaff(UserManagement userManagement, Scanner scanner) {
        System.out.print("Enter Id you want to .... staff ");
        String id = scanner.nextLine();
        int shift;
        do {
            System.out.println("Enter staff's shift [1-4]: ");
            shift = CheckInput.toIntNumeric(scanner.nextLine(), 1, 4);
        } while (shift == -1);
        int index = userManagement.getAcclist().findIndex(id);
        User tmp = (User) userManagement.getAcclist().get(index);
        userManagement.getAcclist().set(index, new Staff(tmp.getId(), tmp.getPassword(), tmp.getFullName(),
                tmp.getRole(), shift));
    }

    public static void blockCustomer(UserManagement userManagement, Scanner scanner) {
        displayUserlist(userManagement);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        int index = userManagement.getAcclist().findIndex(id);
        User tmp = (User) userManagement.getAcclist().get(index);
        userManagement.getAcclist().set(index, new Customer(tmp.getId(), tmp.getPassword(), tmp.getFullName(),
                "0"));
    }

    public static void editProduct(WatchManagement watchManagement, Scanner scanner) {
        displayWatchlist(watchManagement);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        int index = watchManagement.getWatchList().findIndex(id);
        Watches tmp = (Watches) watchManagement.getWatchList().get(index);
        System.out.print("Enter new price");
        String newprice = (CheckInput.toStrNumberic(scanner.nextLine()));
        System.out.print("Enter new quantity");
        String newquantity = (CheckInput.toStrNumberic(scanner.nextLine()));
        if (newprice != null) {
            tmp.setPrice(Double.parseDouble(newprice));
        }
        if (newquantity != null) {
            tmp.setQuantity(Integer.parseInt(newquantity));
        }
        watchManagement.getWatchList().set(index, tmp);
    }

    public static void deleteProduct(WatchManagement watchManagement, Scanner scanner) {
        displayWatchlist(watchManagement);
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        int index = watchManagement.getWatchList().findIndex(id);
        watchManagement.getWatchList().remove(index);
    }
}
