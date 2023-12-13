package bill;

import util.ChangeFormat;

public class Bill {
	private String idUser;
	private String idStaff;
	private String idProduct;
	private String nameProduct;
	private int quantity;
	private String day;
	private long totalPrice;
	private boolean checkBill;

	public Bill(String idUser, String idStaff, String idProduct, String nameProduct, int quantity, String day,
			long totalPrice, boolean checkBill) {
		this.idUser = idUser;
		this.idStaff = idStaff;
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.day = day;
		this.totalPrice = totalPrice;
		this.checkBill = checkBill;
	}

	public Bill(String idUser, String idProduct, String nameProduct, int quantity, String day, long totalPrice) {
		this.idUser = idUser;
		this.idStaff = null;
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.day = day;
		this.totalPrice = totalPrice;
		this.checkBill = false;
	}

	public Bill(Bill bill) {
		this.idUser = bill.getIdUser();
		this.idStaff = bill.getIdStaff();
		this.idProduct = bill.getIdProduct();
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

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean getCheckBill() {
		return checkBill;
	}

	public void setCheckBill(boolean checkBill) {
		this.checkBill = checkBill;
	}

	@Override
	public String toString() {
		return idUser + "\n" + idStaff + "\n" + idProduct + "\n" + nameProduct + "\n" + quantity + "\n" + day + "\n"
				+ ChangeFormat.priceFormat(totalPrice) + "\n" + checkBill;
	}
}
