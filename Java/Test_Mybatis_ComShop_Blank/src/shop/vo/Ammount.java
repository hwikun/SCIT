package shop.vo;

public class Ammount {
	private String code;
	private String name;
	private int ammount;
	private int price;
	
	public Ammount() {
		// TODO Auto-generated constructor stub
	}
	
	public Ammount(String code, String name, int ammount, int price) {
		super();
		this.code = code;
		this.name = name;
		this.ammount = ammount;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ammount [code=" + code + ", name=" + name + ", ammount=" + ammount + ", price=" + price + "]";
	}
	
}
