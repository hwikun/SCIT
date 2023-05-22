package shop.vo;

//판매 정보 VO
public class Sales {
	private int num;				//판매 일련번호
	private String code;			//상품코드
	private int quantity;			//판매수량
	private String inputdate;		//판매시간
		
	public Sales() {
	}

	public Sales(int num, int quantity) {
		this.num = num;
		this.quantity = quantity;
	}

	public Sales(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "Sales [num=" + num + ", code=" + code + ", quantity=" + quantity + ", inputdate=" + inputdate + "]";
	}
}
