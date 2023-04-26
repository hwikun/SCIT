package ch09;

public class Data {
	int num;
	String name;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Data) {
			Data d = (Data) obj;
			if(this.name.equals(d.name) && this.num == d.num) return true;
			else return false;
		} else return false;
	}
	
}
	
	

