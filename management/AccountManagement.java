package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import user.Admin;
import user.Customer;
import user.Staff;
import user.User;
import user.UserList;

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
			try (Scanner scanner = new Scanner(file)) {
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
			}
		} catch (FileNotFoundException e) {
			return false;
		}

		return true;
	}

	public boolean writeFile() {
		try {
			FileWriter writer = new FileWriter(this.filepath);
			for (Object user : this.accountList.getArr()) {
				writer.write(((User) user).toString());
			}
			writer.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean addUser(User user) {
		if (accountList.isObjectAdded(user))
			return false;
		if (user instanceof Admin)
			this.accountList.add(new Admin((Admin) user));
		else if (user instanceof Staff)
			this.accountList.add(new Staff((Staff) user));
		else if (user instanceof Customer)
			this.accountList.add(new Customer((Customer) user));
		return writeFile();
	}

	public boolean removeUser(String username) {
		int index = accountList.findIndex(username);
		if (index == -1)
			return false;
		accountList.remove(index);
		return writeFile();
	}

	public boolean changeAccountInfo(String username, User user) {
		int index = accountList.findIndex(username);
		if (index == -1)
			return false;
		accountList.set(index, user);
		return writeFile();
	}

	public User findUserByUserName(String username) {
		int index = accountList.findIndex(username);
		if (index == -1)
			return null;
		return (User) accountList.get(index);
	}

	public User getAcclist() {
		return (User) accountList;
	}

	public void setAcclist(UserList userList) {
		this.accountList = userList;
	}
}
