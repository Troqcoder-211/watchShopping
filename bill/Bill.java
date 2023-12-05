package bill;

import java.util.ArrayList;

public class Bill {
    private String idBill;
    private String idStaff;
    private ArrayList<String> idProducts;
    private String time;
    private double totalPrice;
    private boolean checkBill;

    public Bill(String idBill, String idStaff, ArrayList<String> idProducts, String time, double totalPrice,
            boolean checkBill) {
        this.idBill = idBill;
        this.idStaff = idStaff;
        this.idProducts = idProducts;
        this.time = time;
        this.totalPrice = totalPrice;
        this.checkBill = checkBill;
    }

    public Bill(String idBill, String idStaff, ArrayList<String> idProducts, String time, double totalPrice) {
        this.idBill = idBill;
        this.idStaff = idStaff;
        this.idProducts = idProducts;
        this.time = time;
        this.totalPrice = totalPrice;
        this.checkBill = false;
    }

    public Bill(Bill bill) {
        this.idBill = bill.getIdBill();
        this.idStaff = bill.getIdStaff();
        this.idProducts = bill.getIdProducts();
        this.time = bill.getTime();
        this.totalPrice = bill.getTotalPrice();
        this.checkBill = bill.getCheckBill();
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public ArrayList<String> getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(ArrayList<String> idProducts) {
        this.idProducts = idProducts;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean getCheckBill() {
        return checkBill;
    }

    public void setCheckBill(boolean checkBill) {
        this.checkBill = checkBill;
    }

}
