package ch08.school;

public class TypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer(1);
		Double b = new Double(0.75);
		Number c = new Integer(5);
		Number d = new Double(2.2);
		Object e = new Integer(3);
		String f = new String("aaa");
		String g = new String("CCC");
		
		System.out.println(a instanceof Integer); // true; 정확히 일치;
		System.out.println(a instanceof Number); // true; 상속관계에서 상위타입은 true;
		System.out.println(a instanceof Object); // true;
//		System.out.println(a instanceof Double); // 상속관계 아님. 컴파일에러;
		System.out.println(c instanceof Double); // false; 상속관계이면서 타입일치안하면 false;
		System.out.println(d instanceof Double); // true;
		System.out.println(e instanceof Integer); // true;
		System.out.println(f instanceof String); // true;
		System.out.println(g instanceof Object); // true;
		
	}

}
