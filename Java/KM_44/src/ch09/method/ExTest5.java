package ch09.method;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score = 0;
		while(true) {
			System.out.print("국어점수 입력: ");
			try {
				score = sc.nextInt();
				sc.nextLine();
				if(score > 100 || score < 0) {
					throw new ScoreException();
				}
			} catch(InputMismatchException e) {
				sc.nextLine();
				continue;
			} catch(ScoreException e) {
				e.printStackTrace();
				continue;
			}
			break;
		}
		
		System.out.println(score);
	}

}
