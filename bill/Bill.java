package bill;

import java.util.ArrayList;

public class Bill {
    private String idUser;
    private String idStaff;
    private ArrayList<String> idProducts;
    private String day;
    private double totalPrice;
    private boolean checkBill;

    public Bill(String idUser, String idStaff, ArrayList<String> idProducts, String day, double totalPrice,
            boolean checkBill) {
        this.idUser = idUser;
        this.idStaff = idStaff;
        this.idProducts = idProducts;
        this.day = day;
        this.totalPrice = totalPrice;
        this.checkBill = checkBill;
    }

    public Bill(String idUser, String idStaff, ArrayList<String> idProducts, String day, double totalPrice) {
        this.idUser = idUser;
        this.idStaff = idStaff;
        this.idProducts = idProducts;
        this.day = day;
        this.totalPrice = totalPrice;
        this.checkBill = false;
    }

    public Bill(Bill bill) {
        this.idUser = bill.getIdUser();
        this.idStaff = bill.getIdStaff();
        this.idProducts = bill.getIdProducts();
        this.day = bill.getDay();
        this.totalPrice = bill.getTotalPrice();
        this.checkBill = bill.getCheckBill();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
