package watch;

public class LuxuryWatch extends Watch {
	private String brand;
	private String material;

	public LuxuryWatch(String id, String name, double price, String brand, String material) {
		super(id, name, price);
		this.brand = brand;
		this.material = material;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "luxury " + super.toString() + " " + brand + " " + material + "\n";
	}

}
