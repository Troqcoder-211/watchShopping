package watchShopping.management;

public interface CustomList {

    public void add(Object object);

    public void remove(int index);

    public Object get(int index);

    public void set(int index, Object object);

    public int size();

    public void clear();

    public int findIndex(Object object);

    public int findIndex(String objectName);

    public boolean isObjectAdded(Object object);

}
