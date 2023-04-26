package ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Data> list = new ArrayList<Data>();
		Data d = new Data();
		d.setNum(1);
		d.setName("모니터");
		list.add(d);
		
		d = new Data();
		d.setNum(2);
		d.setName("키보드");
		list.add(d);
		
		System.out.println(list);
		
		Scanner sc = new Scanner(System.in);
		Data input = new Data();
		System.out.printf("정수 입력: ");
		input.setNum(sc.nextInt());
		System.out.printf("이름 입력: ");
		input.setName(sc.next());
		
		// 입력한 값이 리스트에 있는지 위치출력
		int i = list.indexOf(input);
		System.out.printf("%d", i != -1 ? i : "데이터가 없습니다.");
	}

}
