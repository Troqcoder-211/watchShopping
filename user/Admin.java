package watchShopping.user;

public class Admin extends User {

    public Admin(String id, String password, String name, String role) {
        super(id, password, name, role);
    }

    @Override
    public void userInfoHandler(String id) {
    }
}
