package ch07;

// call by value
public class DeepCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[] = {10, 20, 30, 40, 50};
		int num2[] = new int[num1.length]; // num1 과 같은 배열길이를 가짐
		
		System.arraycopy(num1, 0, num2, 0, num1.length); // 원본 배열, 원본배열의 복사시작위치, 복사할 배열, 복사가 끝나는 위치, 길이)
		num2[0] = 1;
		
		System.out.println("====num1====");
		for(int i : num1) {
			System.out.printf("%d ",i);
		}
		
		System.out.println("");
		System.out.println("====num2====");
		for(int i : num2) {
			System.out.printf("%d ",i);
		}
	}

}
