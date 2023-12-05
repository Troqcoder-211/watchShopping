package user;

import java.util.ArrayList;

import management.CustomList;

public class UserList implements CustomList {
	private ArrayList<Object> userList;

	public UserList() {
		this.userList = new ArrayList<Object>();
	}

	public UserList(ArrayList<Object> userList) {
		this.userList = userList;
	}

	@Override
	public ArrayList<Object> getArr() {
		return userList;
	}

	@Override
	public void setArr(ArrayList<Object> UserList) {
		this.userList = UserList;
	}

	@Override
	public void add(Object user) {
		this.userList.add((User) user);
	}

	@Override
	public boolean remove(int index) {
		if (this.userList != null && index >= 0 && index < this.userList.size()) {
			this.userList.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return this.userList.get(index);
	}

	@Override
	public boolean set(int index, Object user) {
		if (this.userList != null && index >= 0 && index < this.userList.size()) {
			this.userList.set(index, (User) user);
			return true;
		}
		return false;
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
	public int findIndex(String id) {
		for (int i = 0; i < userList.size(); i++)
			if (((User) this.userList.get(i)).getId().equals(id))

				return i;
		return -1;
	}

	@Override
	public boolean isObjectAdded(Object user) {
		return findIndex(((User) user).getId()) >= 0;
	}

}