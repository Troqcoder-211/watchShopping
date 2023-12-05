package user;

public class Admin extends User {

	public Admin(String id, String password, String fullname, String role) {
		super(id, password, fullname, role);
	}

	public Admin(Admin user) {
		super(user.getId(), user.getPassword(), user.getFullName(), user.getRole());
	}

}
