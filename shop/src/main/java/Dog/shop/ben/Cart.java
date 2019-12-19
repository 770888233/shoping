package Dog.shop.ben;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private double totale;
	
	private Map<Integer, CartItem> map = new HashMap<>();

	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	public Map<Integer, CartItem> getCartItem() {
		return map;
	}

	public void setCartItem(Map<Integer, CartItem> cartItem) {
		this.map = cartItem;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public void addCart(CartItem item) {
		Integer pid = item.getProduct().getPid();
		if (map.containsKey(pid)) {
			CartItem existItem = map.get(pid);
			existItem.setCount(item.getCount() + existItem.getCount());
			existItem.setSubtotle(item.getSubtotle() + existItem.getSubtotle());
		} else {
			map.put(pid, item);
		}
		totale = totale + item.getSubtotle();
	}

	public void delProFromCart(int pid) {
		CartItem item = map.remove(pid);
		totale = totale - item.getSubtotle();
	}

	public void clearCart() {
		map.clear();
		totale = 0;
	}
}
