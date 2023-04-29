package ch09.method;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		try {
			while(true) {
				System.out.printf("정수 입력: ");
				list.add(sc.nextInt());
			}
		} catch(InputMismatchException e) {
			
		}
			
		
	}

}
//정수 입력
//2
//4
//5
//10
//a
//임의의개수의 숫자를 입력받아 배열에 넣고 숫자가 아닌걸 입력받으면 그동안 입력받은 숫자의 총합을출력.
// 2 + 4 + 5 + 10 = 20