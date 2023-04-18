package ch08.school;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("홍길동", "001122-1111111", "010-1234-5678", 90, 90, 86);
		Teacher t1 = new Teacher("선생님", "901012-1112221", "010-4567-5678", 5_000_000);
		
		System.out.println(s1.getTotal());
		System.out.printf("%.2f\n", s1.getAvg());
		System.out.println(s1);
		System.out.println(t1.toString());
		
//		Person p = new Student(); // 거꾸로는 안됨.
//		Person p2 = new Teacher(); // 상위 타입이 하위객체 참조 가능;
	}

}
