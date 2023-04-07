package ch03.test;
import java.util.Scanner;

public class Exam_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시간을 초 단위로 입력하세요: ");
		int time = sc.nextInt();
		int hour = time / 3600;
		int minute = (time % 3600) / 60;
		int sec = time % 60;
		System.out.printf("%d초는 %d시간 %d분 %d초 입니다.", time, hour, minute, sec);
	}

}
