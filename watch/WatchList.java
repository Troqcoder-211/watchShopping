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
	public void add(Object watch) {
		this.listOfWatches.add((Watches) watch);
	}

	@Override
	public boolean remove(int index) {
		if (this.listOfWatches != null && index >= 0 && index < this.listOfWatches.size()) {
			this.listOfWatches.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return this.listOfWatches.get(index);
	}

	@Override
	public boolean set(int index, Object watch) {
		if (this.listOfWatches != null && index >= 0 && index < this.listOfWatches.size()) {
			this.listOfWatches.set(index, (Watches) watch);
			return true;
		}
		return false;
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
	public int findIndex(Object watch) {
		return this.listOfWatches.indexOf((Watches) watch);
	}

	@Override
	public int findIndex(String id) {
		for (int i = 0; i < listOfWatches.size(); i++)
			if (((Watches) this.listOfWatches.get(i)).getId().equals(id))
				return i;
		return -1;
	}

	@Override
	public boolean isObjectAdded(Object watch) {
		return this.findIndex(((Watches) watch).getId()) >= 0;
	}

}
