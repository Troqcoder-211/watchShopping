package watch;

public class NormalWatch extends Watch {

	public NormalWatch(String id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return "normal " + super.toString() + "\n";
	}

}
