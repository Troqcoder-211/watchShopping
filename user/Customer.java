package user;

public class Customer extends User {

	// CUS <KH_><anything>
	// regex ^KH_\\w+$
	// ex KH_abcdefghi
	private String username;

	public Customer(String id, String password, String name, String role) {
		super(id, password, name, role);
		userInfoHandler(id);
	}

	public Customer(Customer user) {
		super(user.getId(), user.getPassword(), user.getName(), user.getRole());
		this.username = user.getUsername();
	}

	@Override
	public void userInfoHandler(String id) {
		this.username = (id.replaceAll("KH_", ""));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
