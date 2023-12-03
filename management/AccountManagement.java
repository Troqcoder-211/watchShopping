package watchShopping.management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import watchShopping.user.*;

public class AccountManagement {
    private CustomList accountList;
    private String filepath;

    public AccountManagement(String filepath) {
        this.accountList = new UserList();
        this.filepath = filepath;
    }

    public boolean readFile() {
        try {
            File file = new File(this.filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String id = scanner.next();
                String password = scanner.next();
                String name = scanner.next();
                String role = scanner.next();
                scanner.nextLine();
                if (role.equalsIgnoreCase("admin")) {
                    this.accountList.add(new Admin(id, password, name, role));
                } else if (role.equalsIgnoreCase("staff")) {
                    this.accountList.add(new Staff(id, password, name, role));
                } else if (role.equalsIgnoreCase("customer")) {
                    this.accountList.add(new Customer(id, password, name, role));
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public boolean writeFile() {
        try {
            FileWriter writer = new FileWriter(this.filepath);
            for (User user : this.accountList.getUserList()) {
                writer.write(user.toString());
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean addUser(User user) {
        if (accountList.isObjectAdded(user)) {
            return false;
        }
        if (user instanceof Admin) {
            accountList.add(user);
        } else if (user instanceof Staff) {
            accountList.add(user);
        } else {

        }
        return true;
    }
}
