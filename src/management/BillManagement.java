package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bill.Bill;
import function.GeneralFunction;
import util.Constant;
import watch.Watches;

public class BillManagement {
	private Bill bill;
	private String filepath;

	public BillManagement(String baseDir, String fileName) {
		this.filepath = baseDir + fileName;
		readFile();
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
					int quantity = Integer.parseInt(scanner.nextLine());
					String time = scanner.nextLine();
					double totalPrice = Double.parseDouble(scanner.nextLine());
					boolean checkBill = Boolean.parseBoolean(scanner.nextLine());

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
		WatchManagement watchMGR = new WatchManagement(Constant.dataPath.watches_File);
		int index = watchMGR.getWatchList().findIndex(bill.getIdProduct());
		watchMGR.setQuantity(index, ((Watches) watchMGR.getWatchList().get(index)).getQuantity() - bill.getQuantity());
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
