package test230508;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HwisunNa {

	public static void main(String[] args) {
		/* TODO 정수 10개가 저장된 열을 생성하고, 저장된 모든 값들을 비교하여 전체 배열데이터와 최
		대값, 최소값을 다음과 같이 출력한다. (30점)*/
		int arr1[] = {5, 10, 23, 50, 34, 100, 23, 2, 3, 20};
		System.out.print("배열:");
		for(int el: arr1) {
			System.out.printf(" %d", el);
		}
		System.out.println();
		int temp;
		for(int i=0; i<arr1.length-1; i++) {
			for(int j=i+1; j<arr1.length; j++) {
				if(arr1[i] > arr1[j]) {
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}
		}
		System.out.printf("최댓값: %d\n", arr1[arr1.length-1]);
		System.out.printf("최소값: %d\n", arr1[0]);
		
		/* TODO 정수 2개를 입력 받아 합계를 구하여, 현재 경로에 “2번답안.txt” 이름의 텍스트 파일에
		저장한다. 생성된 파일은 메모장으로 열었을 때 다음과 같이 보여야 한다. (30점)
		(답이 100인 경우)*/
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		int a, b;
		System.out.printf("정수 a 입력: ");
		a = sc.nextInt();
		System.out.printf("정수 b 입력: ");
		b = sc.nextInt();
		try {
			fw = new FileWriter("2번답안.txt");
			fw.write(Integer.toString(a+b));
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("파일 생성 실패");
		}
		
		/* TODO 키보드로 문자열을 입력 아 해당 문자열이 거꾸로 읽어도 같은 내용인지 여부를 출력한
		다. 띄어쓰기나 마침표는 입력하지 않는다. (20점) */
		sc.nextLine();
		boolean result = true;
		System.out.printf("문자열 입력: ");
		String s1 = sc.nextLine();
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s1.charAt(s1.length()-1-i)) {
				result = false;
			}
		}
		System.out.printf("%b\n", result);
	}

}
