package management;

import java.util.ArrayList;

public interface CustomList {

	public ArrayList<Object> getArr();

	public void setArr(ArrayList<Object> object);

	public void add(Object object);

	public boolean remove(int index);

	public Object get(int index);

	public boolean set(int index, Object object);

	public int size();

	public void clear();

	public int findIndex(Object object);

	public int findIndex(String text);

	public boolean isObjectAdded(Object object);

}
