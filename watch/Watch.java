package watchShopping.watch;

import java.util.ArrayList;
import watchShopping.management.*;

public class Watch {
    // id ,name,gia ,mau
    private String id;
    private String name;
    private double price;

    public Watch(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price;
    }
}

class NormalWatch extends Watch {

    public NormalWatch(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "normal " + super.toString() + "\n";
    }

}

class LuxuryWatch extends Watch {
    private String brand;
    private String material;

    public LuxuryWatch(String id, String name, double price, String brand, String material) {
        super(id, name, price);
        this.brand = brand;
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "luxury " + super.toString() + " " + brand + " " + material + "\n";
    }

}

class WatchList implements CustomList {
    ArrayList<Watch> listOfWatches = new ArrayList<>();

    public WatchList(ArrayList<Watch> listOfWatches) {
        this.listOfWatches = listOfWatches;
    }

    public WatchList() {
    }

    public ArrayList<Watch> getListOfWatches() {
        return listOfWatches;
    }

    public void setListOfWatches(ArrayList<Watch> listOfWatches) {
        this.listOfWatches = listOfWatches;
    }

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
            if (this.listOfWatches.get(i).getId().equals(UserName))

                return i;
        return -1;
    }

    @Override
    public boolean isObjectAdded(Object user) {
        return this.findIndex(((Watch) user).getId()) >= 0;
    }

}
