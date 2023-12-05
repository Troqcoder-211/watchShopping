package watch;

public class Watches {

	private String id;
	private String name;
	private String brand;
	private String type;
	private double price;
	private int quantity;

	public Watches(String id, String name, String brand, String type, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + brand + " " + type + " " + price + " " + quantity;
	}

}
