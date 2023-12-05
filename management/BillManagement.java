package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bill.Bill;
import bill.BillList;

public class BillManagement {
    private CustomList billList;
    private String filepath;

    public BillManagement(String baseDir, String fileName) {
        this.filepath = baseDir + fileName;
        this.billList = new BillList();
        if (!readFile()) {
            filepath = null;
            this.billList = null;
        }
    }

    public boolean readFile() {
        try {
            File file = new File(this.filepath);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String idBill = scanner.next();
                    String idStaff = scanner.next();
                    String time = scanner.next();
                    Double totalPrice = scanner.nextDouble();
                    boolean checkBill = scanner.nextBoolean();
                    ArrayList<String> idProducts = new ArrayList<String>();
                    String line = scanner.nextLine();
                    String[] product = line.split(" ");
                    for (int i = 0; i < product.length; i++) {
                        idProducts.add(product[i]);
                    }

                    this.billList.add(new Bill(idBill, idStaff, idProducts, time, totalPrice, checkBill));
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
            for (Object bill : this.billList.getArr()) {
                Bill tmpBill = new Bill((Bill) bill);
                writer.write(
                        tmpBill.getIdBill() + " " + tmpBill.getIdStaff() + " " + tmpBill.getTime() + " "
                                + tmpBill.getTotalPrice() + " " + tmpBill.getCheckBill());
                for (String tmpString : tmpBill.getIdProducts()) {
                    writer.write(tmpString + " ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean addBill(Bill bill) {
        if (this.billList.isObjectAdded(bill)) {
            return false;
        }
        this.billList.add(bill);
        return writeFile();
    }

    public boolean removeBill(int index) {
        if (!this.billList.remove(index)) {
            return false;
        }
        return writeFile();
    }

    public boolean verifyBill(int index) {
        ((Bill) this.billList.get(index)).setCheckBill(true);
        return true;
    }
}
