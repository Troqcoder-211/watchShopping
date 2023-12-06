package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bill.Bill;
import bill.BillList;
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
                    String idUser = scanner.next();
                    String idStaff = scanner.next();
                    String idProducts = scanner.next();
                    String nameProduct = scanner.next();
                    int quantity = Integer.parseInt(scanner.next());
                    String time = scanner.next();
                    Double totalPrice = scanner.nextDouble();
                    boolean checkBill = scanner.nextBoolean();

                    this.bill = new Bill(idUser, idStaff, idProducts, nameProduct, quantity, time, totalPrice,
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

            writer.write("\n");

            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
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

    public void VerifyBill(String staffID) {
        bill.setCheckBill(true);
        bill.setIdStaff(staffID);
        writeFile();
    }

}
