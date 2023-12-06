package cart;

import management.CustomList;


import java.util.ArrayList;

public class CartList implements CustomList {
    ArrayList<Object> listOfCarts = new ArrayList<Object>();

	public CartList(ArrayList<Object> listOfCarts) {
		this.listOfCarts = listOfCarts;
	}

	public CartList() {
	}

	@Override
	public ArrayList<Object> getArr() {
		return listOfCarts;
	}

	@Override
	public void setArr(ArrayList<Object> listOfCarts) {
		this.listOfCarts = listOfCarts;
	}

	@Override
	public void add(Object cart) {
		this.listOfCarts.add((Cart) cart);
	}

	@Override
	public boolean remove(int index) {
		if (this.listOfCarts != null && index >= 0 && index < this.listOfCarts.size()) {
			this.listOfCarts.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return this.listOfCarts.get(index);
	}

	@Override
	public boolean set(int index, Object cart) {
		if (this.listOfCarts != null && index >= 0 && index < this.listOfCarts.size()) {
			this.listOfCarts.set(index, (Cart) cart);
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.listOfCarts.size();
	}

	@Override
	public void clear() {
		this.listOfCarts.clear();
	}

	@Override
	public int findIndex(Object cart) {
		return this.listOfCarts.indexOf((Cart) cart);
	}

	@Override
	public int findIndex(String id) {
		for (int i = 0; i < listOfCarts.size(); i++)
			if (((Cart) this.listOfCarts.get(i)).getId().equals(id))
				return i;
		return -1;
	}

	@Override
	public boolean isObjectAdded(Object cart) {
		return this.findIndex(((Cart) cart).getId()) >= 0;
	}
}
