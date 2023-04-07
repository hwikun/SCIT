package ch04;

public class IfExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 60, charge;
		if (age < 8) {
			charge = 1000;
			System.out.println("미취학아동 입니다");
		}
		else if (age < 14) {
			charge = 2000;
			System.out.println("초등학생 입니다");
		}
		else if (age < 20) {
			charge = 2500;
			System.out.println("중, 고등학생입니다");
		}
		else {
			charge =  3000;
			System.out.println("일반인입니다");
		}
		System.out.printf("입장료는 %d원 입니다", charge);
	}

}
