package shop.vo;

//상품 정보 VO
public class Product {
	private String code;		//상품코드
	private String pname;		//상품명
	private int price;			//가격
	
	public Product() {
	}

	public Product(String code, String pname, int price) {
		this.code = code;
		this.pname = pname;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", pname=" + pname + ", price=" + price + "]";
	}
}
