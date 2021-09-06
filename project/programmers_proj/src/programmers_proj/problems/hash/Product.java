package programmers_proj.problems.hash;

public class Product {
	
	String item = "";
	int price = 0;
	
	public Product(String item, int price) {
		this.item = item;
		this.price = price;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [item=" + item + ", price=" + price + "]";
	}
	
	
	
}
