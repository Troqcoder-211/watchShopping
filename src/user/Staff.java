package user;

public class Staff extends User {

	private int shift;

	public Staff(String id, String password, String name, String role, int shift) {
		super(id, password, name, role);
		this.shift = shift;
	}

	public Staff(Staff staff) {
		super(staff.getId(), staff.getPassword(), staff.getFullName(), staff.getRole());
		this.shift = staff.getShift();
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return super.toString() + " " + shift;
	}
}
