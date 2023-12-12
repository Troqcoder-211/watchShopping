package user;

public abstract class User {
	private String id;// sdt
	private String password;
	private String fullName;
	private String role;

	public User(String id, String password, String fullName, String role) {
		this.id = id;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullname) {
		this.fullName = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString() {
		return id + " " + password + " " + fullName + " " + role;
	}

}
