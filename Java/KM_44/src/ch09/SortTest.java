package ch09;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = new int[6];
		int n;
		loop:
			for(int i=0; i<num.length; i++) {
				n = (int)(Math.random() * 45) +1;
				for(int j=0; j<=i; j++) {
					if(n == num[j]) {
						i--;
						continue loop;
					}
				}
				num[i] = n;
			}
		int i, j, tmp;
		boolean flag;
		int a = 0, b = 0;
		
		// 정렬 전
		System.out.printf("[");
		for(int x=0; x<num.length; x++) {
			System.out.print(num[x]);
			if(x < num.length-1) System.out.printf(", ");
		}
		System.out.println("]");
		// 버블정렬
		for(i=num.length; i>0; i--) {
			flag = true;
			for(j=0; j<i; j++) {
				a++;
				if(num[j] > num[j+1]) {
					flag = false;
					b++;
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
			}
			if (flag) break;
		}
		// 정렬 후
		System.out.printf("[");
		for(int x=0; x<num.length; x++) {
			System.out.printf("%d", num[x]);
			if(x < num.length -1) System.out.printf(", ");
		}
		System.out.println("]");
		System.out.printf("비교: %d / 교환: %d", a, b);
	}

}
