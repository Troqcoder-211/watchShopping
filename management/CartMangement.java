package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import cart.CartList;


import watch.Watches;
import cart.Cart;

public class CartMangement {
    
    private CustomList cartList;
    private String filepath;


    public CartMangement(String filepath) {
        this.cartList = new CartList();
        this.filepath = filepath;        
        if (!readFile()) {
            filepath = null;
            cartList = null;
        }
    }


    public boolean readFile() {
        try {
            File file = new File(this.filepath);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String id = scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                    this.cartList.add(new Cart(id));
                }
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
            for (Object cart : this.cartList.getArr()) {
                writer.write(((Cart)cart).getId()+"\n");
                for (Object watch : ((Cart)cart).getWatchList().getArr()) {
                        
                        writer.write(((Watches)watch).toString()+"\n");
    
                }
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean addCart(Cart cart) {
        if (cartList.isObjectAdded(cart))
            return false;
        this.cartList.add(cart);
        return writeFile();
    }

    public boolean removeCart(String id) {
        int index = cartList.findIndex(id);
        if (index == -1)
            return false;
        cartList.remove(index);
        return writeFile();
    }

    public int searchCartById(String id) {
        return cartList.findIndex(id);
    }

    
	public boolean changeCartInfo(String id, Cart cart) {
		int index = cartList.findIndex(id);
		if (index == -1)
			return false;
		cartList.set(index, cart);
		return writeFile();
	}


	public CartList getCartlist() {
		return (CartList) cartList;
	}

	public void setCartlist(CartList cartList) {
		this.cartList = cartList;
	}
    

    
}
