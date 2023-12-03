package user;

public class Staff extends User {

	// STAFF <NV><ca><stt>
	// regex ^NV\\d\\d{3}$
	// ex NV1001
	private int shift;
	private int orderNumber;

	public Staff(String id, String password, String name, String role) {
		super(id, password, name, role);
		userInfoHandler(id);
	}

	public Staff(Staff user) {
		super(user.getId(), user.getPassword(), user.getName(), user.getRole());
		this.shift = user.getShift();
		this.orderNumber = user.getOrderNumber();
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public void userInfoHandler(String id) {
		char tmp[] = (id.replaceAll("[^0-9]", "")).toCharArray();
		this.orderNumber = Integer.parseInt(String.copyValueOf(tmp, 1, 3));
		this.shift = Integer.parseInt(String.valueOf(tmp[0]));
	}

}
