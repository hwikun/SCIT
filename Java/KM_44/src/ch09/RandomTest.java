package ch09;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[6];
		int n;
		 
		// 1-45까지의 임의의 정수를 배열에 저장(중복불가)
		// 숫자6개 출력
		loop:
		for(int i=0; i<num.length; i++) {
			n = (int)(Math.random() * 6) +1;
			for(int j=0; j<=i; j++) {
				if(n == num[j]) {
					i--;
					continue loop;
				}
			}
			num[i] = n;
		}
		System.out.println("정렬 전");
		System.out.print("[");
		for(int i=0; i<num.length; i++) {
			System.out.printf("%d%s", num[i], (i< num.length -1 ? ", " : ""));
		}
		System.out.println("]");

		
		
		// 교환정렬 interchange sort
		int temp1 = 0;
		int a = 0, b = 0; // 비교횟수,교환횟수;
		for(int i=0; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				a++;
				if(num[i] > num[j]) {
					b++;
					temp1 = num[i];
					num[i] = num[j];
					num[j] = temp1;
				}
			}
		}
		// 출력
		System.out.println("정렬 후");
		System.out.print("[");
		for(int i=0; i<num.length; i++) {
			System.out.printf("%d%s", num[i], (i< num.length -1 ? ", " : ""));
		}
		System.out.println("]");
		System.out.printf("비교횟수 a: %d / 교환횟수 b: %d", a, b);
	}

}
