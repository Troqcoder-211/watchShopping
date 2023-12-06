package bill;

import java.util.ArrayList;

import management.CustomList;

public class BillList implements CustomList {

	private ArrayList<Object> billList;

	public BillList(ArrayList<Object> billList) {
		this.billList = billList;
	}

	public BillList() {
	}

	@Override
	public ArrayList<Object> getArr() {
		return billList;
	}

	@Override
	public void setArr(ArrayList<Object> object) {
		this.billList = object;
	}

	@Override
	public void add(Object object) {
		this.billList.add((Bill) object);
	}

	@Override
	public boolean remove(int index) {
		if (this.billList != null && index >= 0 && index < this.billList.size()) {
			this.billList.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public Object get(int index) {
		return this.billList.get(index);
	}

	@Override
	public boolean set(int index, Object object) {
		if (this.billList != null && index >= 0 && index < this.billList.size()) {
			this.billList.set(index, (Bill) object);
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.billList.size();
	}

	@Override
	public void clear() {
		this.billList.clear();
	}

	@Override
	public int findIndex(Object object) {
		return this.billList.indexOf((Bill) object);
	}

	@Override
	public int findIndex(String text) {
		for (int i = 0; i < this.billList.size(); i++) {
			if (((Bill) billList.get(i)).getIdUser().equals(text)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isObjectAdded(Object object) {
		return findIndex(((Bill) object).getIdUser()) >= 0;
	}
}
