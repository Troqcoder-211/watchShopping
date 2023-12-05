package function;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import management.BillManagement;
import management.UserManagement;
import management.WatchManagement;
import util.CheckInput;
import util.Constant;
import util.Menu;
import watch.Watches;

public class StaffFunction {
    static UserManagement userManagement = new UserManagement(Constant.dataPath.accounts_File);

    public static void StaffManagement(WatchManagement watchManagement, Scanner scanner) {
        Menu.staff();
        String choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
        } while (choice != "1" && choice != "2" && choice != "0");
        switch (choice) {
            case "1":
                viewProduct(watchManagement);
                break;
            case "2":
                viewBills(scanner);
                break;
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

    public static void viewBills(Scanner scanner) {
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
                billManagement.VerifyBill();
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
