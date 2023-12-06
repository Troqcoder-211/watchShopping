package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bill.Bill;
import function.GeneralFunction;

public class BillManagement {
	private Bill bill;
	private String filepath;

	public BillManagement(String baseDir, String fileName) {
		this.filepath = baseDir + fileName;
		if (!readFile() || !GeneralFunction.createFile(filepath)) {
			filepath = null;
			this.bill = null;
		}
	}

	public boolean readFile() {
		try {
			File file = new File(this.filepath);
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String idUser = scanner.nextLine();
					String idStaff = scanner.nextLine();
					String idProduct = scanner.nextLine();
					String nameProduct = scanner.nextLine();
					int quantity = scanner.nextInt();
					String time = scanner.nextLine();
					double totalPrice = scanner.nextDouble();
					boolean checkBill = scanner.nextBoolean();

					this.bill = new Bill(idUser, idStaff, idProduct, nameProduct, quantity, time, totalPrice,
							checkBill);
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	public boolean writeFile() {
		try {
			File file = new File(this.filepath);
			file.createNewFile();
			FileWriter writer = new FileWriter(this.filepath);
			writer.write(bill.toString());
			writer.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean addBill(Bill bill) {
		setBill(bill);
		return writeFile();
	}

	public boolean removeBill() {
		return GeneralFunction.removeFile(this.filepath);
	}

	public void VerifyBill(String staffID) {
		bill.setCheckBill(true);
		bill.setIdStaff(staffID);
		writeFile();
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
