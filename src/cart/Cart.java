package cart;

import management.CustomList;
import watch.WatchList;
import watch.Watches;



public class Cart {
    String id;
    double totalFunds;
    private CustomList watchList;

    public Cart(String id){
        this.setId(id);
        this.watchList= new WatchList();
        this.totalFunds=0;
    }
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    public void addToCart(String id, String name, String brand, String type, double price, int quantity){
        this.watchList.add(new Watches(id, name, brand, type, price, quantity));
        this.cashRegister();
    }
    public void removeFromCart(int index){
        this.watchList.remove(index);
        this.cashRegister();
    }
    public void resetCart(){
        this.watchList.clear();
        this.totalFunds=0;
    }
    public double cashRegister(){
        double total=0;
        for (Object watch : this.watchList.getArr()) {
            if (watch instanceof Watches){
                total+=((Watches)watch).getPrice();
                    
                }
        } 
        return this.totalFunds=total;
    }

    public void showCart(){
        System.out.println("ID: " + this.getId());
        for (Object watch : this.watchList.getArr()) {
            if (watch instanceof Watches){
                System.out.println(((Watches)watch).toString()+"/n");
                }
        } 
    }
    public WatchList getWatchList(){
        return (WatchList)watchList;
    }
    
}


