package user;

public class Admin extends User {

	public Admin(String id, String password, String name, String role) {
		super(id, password, name, role);
	}

	public Admin(Admin user) {
		super(user.getId(), user.getPassword(), user.getName(), user.getRole());
	}

	@Override
	public void userInfoHandler(String id) {
	}
}
