package Dog.shop.ben;


public class CartItem {
	private Product product;
	private int count;
	private double subtotle;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotle() {
		return subtotle;
	}
	public void setSubtotle(double subtotle) {
		this.subtotle = subtotle;
	}
}
