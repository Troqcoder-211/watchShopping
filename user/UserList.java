package watchShopping.user;

import java.util.ArrayList;

import watchShopping.management.*;

public class UserList implements CustomList {
    ArrayList<User> userList = new ArrayList<>();

    public UserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> UserList) {
        this.userList = UserList;
    }

    @Override
    public void add(Object user) {
        this.userList.add((User) user);
    }

    @Override
    public void remove(int index) {
        if (this.userList != null && index >= 0 && index < this.userList.size()) {
            this.userList.remove(index);
        }
    }

    @Override
    public Object get(int index) {
        return this.userList.get(index);
    }

    @Override
    public void set(int index, Object user) {
        if (this.userList != null && index >= 0 && index < this.userList.size()) {
            this.userList.set(index, (User) user);
        }
    }

    @Override
    public int size() {
        return this.userList.size();
    }

    @Override
    public void clear() {
        this.userList.clear();
    }

    @Override
    public int findIndex(Object user) {
        return this.userList.indexOf((User) user);
    }

    @Override
    public int findIndex(String UserName) {
        for (int i = 0; i < userList.size(); i++)
            if (this.userList.get(i).getId().equals(UserName))

                return i;
        return -1;
    }

    @Override
    public boolean isObjectAdded(Object user) {
        return this.findIndex(((User) user).getId()) >= 0;
    }

}