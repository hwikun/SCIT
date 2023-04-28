package ch09.method;

public class Data {
	int x, y;
	
	public Data() {
		
	}
	public Data(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + "]";
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("x: %d, y: %d\n", this.x, this.y);
	}
	public int sum() {
		// TODO sum;
		return this.x + this.y;
	}
	public static int sum(int i, int j) {
		// TODO Overloading
		return i + j;
	}
	public static int power(int i, int j) {
		// TODO power;
		int result = 1;
		for(int x=0; x<j; x++) {
			result *= i;
		}
		return result;
	}
	public static int sum(int i, int j, int k) {
		// TODO i부터 j까지 k만큼 증가하며 합계;
		int result = 0;
		for(int x=i; x<=j; x+=k) {
			result += x;
		}
		return result;
	}
	
	
}
