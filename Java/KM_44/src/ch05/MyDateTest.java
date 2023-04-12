package ch05;

public class MyDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate date1 = new MyDate(30, 2, 2000);
		System.out.println(date1.isValid() ? "유효한 날짜입니다." : "유효하지 않은 날짜입니다");
		MyDate date2 = new MyDate(29, 2, 2020);
		System.out.println(date2.isValid() ? "유효한 날짜입니다." : "유효하지 않은 날짜입니다");
	}

}
