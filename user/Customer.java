package user;

public class Customer extends User {

	private String status;

	public Customer(String id, String password, String name, String role, String status) {
		super(id, password, name, role);
		this.status = status;
	}

	public Customer(Customer user) {
		super(user.getId(), user.getPassword(), user.getFullName(), user.getRole());
		this.status = user.getStatus();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return super.toString() + " " + status;
	}
}
