package ch06;


public class CountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count c1 = new Count();
		Count c2 = new Count();
		Count.counter++; // static 변수는 클래스 이름으로 바로 호출가능
		Count c3 = new Count();
		System.out.println("c1 serialNumber = "+c1.serialNumber);
		System.out.println("c2 serialNumber = "+c2.serialNumber);
		
		// 클래스 변수는 모든 객체에 의해 값이 공유된다.
		System.out.println("c3 serialNumber = "+c3.serialNumber);
		System.out.println("c3 nonStaticNumber = "+c3.nonStaticNumber);
	}

}

class Count {
	public int serialNumber;
	public static int counter = 0;
	public int nonStaticNumber;
	
	public Count() {
		counter++;
		serialNumber = counter;
		nonStaticNumber++;
	}
}