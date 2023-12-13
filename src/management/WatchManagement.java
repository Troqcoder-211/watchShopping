package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import function.GeneralFunction;
import watch.WatchList;
import watch.Watches;

public class WatchManagement {

	private CustomList watchList;
	private String filepath;

	public WatchManagement(String filepath) {
		this.watchList = new WatchList();
		this.filepath = filepath;
		if (!readFile() || !GeneralFunction.createFile(filepath)) {
			filepath = null;
			watchList = null;
		}
	}

	public boolean readFile() {
		long price;
		int quantity;
		String id;
		String brand;
		String type;
		String name;
		try {
			File file = new File(this.filepath);
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {

					id = scanner.next();
					brand = scanner.next();
					type = scanner.next();
					String strPrice = scanner.next();
					price = Long.parseLong(strPrice.replaceAll("\\D",""));
					quantity = scanner.nextInt();
					name = scanner.nextLine();

					this.watchList.add(new Watches(id, name, brand, type, price, quantity));
				}
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	public boolean writeFile() {
		try {
			File file = new File(this.filepath);
			file.createNewFile();
			FileWriter writer = new FileWriter(this.filepath);
			for (Object watch : this.watchList.getArr()) {
				if (watch instanceof Watches)
					writer.write(((Watches) watch).toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean addWatches(Watches watch) {
		if (watchList.isObjectAdded(watch))
			return false;
		this.watchList.add(watch);
		return writeFile();
	}

	public boolean removeWatches(String id) {
		int index = watchList.findIndex(id);
		if (index == -1)
			return false;
		watchList.remove(index);
		return writeFile();
	}

	public int searchWatchesById(String id) {
		return watchList.findIndex(id);
	}

	public ArrayList<Integer> searchIndexByName(String name) {
		ArrayList<Integer> arrayOfindex = new ArrayList<Integer>();
		for (Object watch : this.watchList.getArr()) {
			if (((Watches) watch).getName().contains(name)) {
				arrayOfindex.add(this.watchList.findIndex(watch));
			}
		}
		return arrayOfindex;
	}

	public ArrayList<Watches> searchWatchesByName(String name) {
		ArrayList<Watches> arrayOfWatches = new ArrayList<Watches>();
		for (Object watch : this.watchList.getArr()) {
			if (((Watches) watch).getName().contains(name)) {
				arrayOfWatches.add((Watches) watch);
			}
		}
		return arrayOfWatches;
	}

	public ArrayList<Integer> searchIndexByBrand(String brand) {
		ArrayList<Integer> arrayOfIndex = new ArrayList<Integer>();
		for (Object watch : watchList.getArr()) {
			if (((Watches) watch).getBrand().equalsIgnoreCase(brand)) {
				arrayOfIndex.add(this.watchList.findIndex(watch));
			}
		}
		return arrayOfIndex;
	}

	public ArrayList<Watches> searchWatchesByBrand(String brand) {
		ArrayList<Watches> arrayofWatches = new ArrayList<Watches>();
		for (Object watch : watchList.getArr()) {
			if (((Watches) watch).getBrand().equalsIgnoreCase(brand)) {
				arrayofWatches.add((Watches) watch);
			}
		}
		return arrayofWatches;
	}

	public ArrayList<Integer> searchIndexByPrice(long low, long high) {
		ArrayList<Integer> arrayofIndex = new ArrayList<Integer>();
		for (Object watch : watchList.getArr()) {
			if (((Watches) watch).getPrice() <= high && ((Watches) watch).getPrice() >= low) {
				arrayofIndex.add(this.watchList.findIndex(watch));
			}
		}
		return arrayofIndex;
	}

	public boolean setPrice(int index, long price) {
		if (this.watchList != null && index >= 0 && index < this.watchList.size()) {
			((Watches) this.watchList.get(index)).setPrice(price);
			writeFile();
			return true;
		}
		return false;
	}

	public boolean setQuantity(int index, int quantity) {
		if (this.watchList != null && index >= 0 && index < this.watchList.size()) {
			((Watches) this.watchList.get(index)).setQuantity(quantity);
			writeFile();
			return true;
		}
		return false;
	}

	public long getPrice(int index){
			return ((Watches) this.watchList.get(index)).getPrice();
	}

	public int getQuantity(int index){
			return ((Watches) this.watchList.get(index)).getQuantity();
	}

	public String getName(int index){
			return ((Watches) this.watchList.get(index)).getName();
	}

	public String getBrand(int index){
			return ((Watches) this.watchList.get(index)).getBrand();
	}
	
	public String getType(int index){
			return ((Watches) this.watchList.get(index)).getType();
	}

	public CustomList getWatchList() {
		return watchList;
	}

	public void setWatchList(CustomList watchList) {
		this.watchList = watchList;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
