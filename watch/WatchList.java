package watch;

import java.util.ArrayList;

import management.CustomList;

public class WatchList implements CustomList {
	ArrayList<Object> listOfWatches = new ArrayList<Object>();

	public WatchList(ArrayList<Object> listOfWatches) {
		this.listOfWatches = listOfWatches;
	}

	public WatchList() {
	}

	@Override
	public ArrayList<Object> getArr() {
		return listOfWatches;
	}

	@Override
	public void setArr(ArrayList<Object> listOfWatches) {
		this.listOfWatches = listOfWatches;
	}

	@Override
	public void add(Object user) {
		this.listOfWatches.add((Watch) user);
	}

	@Override
	public void remove(int index) {
		if (this.listOfWatches != null && index >= 0 && index < this.listOfWatches.size()) {
			this.listOfWatches.remove(index);
		}
	}

	@Override
	public Object get(int index) {
		return this.listOfWatches.get(index);
	}

	@Override
	public void set(int index, Object user) {
		if (this.listOfWatches != null && index >= 0 && index < this.listOfWatches.size()) {
			this.listOfWatches.set(index, (Watch) user);
		}
	}

	@Override
	public int size() {
		return this.listOfWatches.size();
	}

	@Override
	public void clear() {
		this.listOfWatches.clear();
	}

	@Override
	public int findIndex(Object user) {
		return this.listOfWatches.indexOf((Watch) user);
	}

	@Override
	public int findIndex(String UserName) {
		for (int i = 0; i < listOfWatches.size(); i++)
			if (((Watch) this.listOfWatches.get(i)).getId().equals(UserName))

				return i;
		return -1;
	}

	@Override
	public boolean isObjectAdded(Object user) {
		return this.findIndex(((Watch) user).getId()) >= 0;
	}

}
