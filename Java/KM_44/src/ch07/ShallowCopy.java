package ch07;

// call by reference
public class ShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 [] = {10, 20, 30, 40, 50};
		int num2 [] = num1;
		
		num2[0] = 1;
		System.out.println("====num1====");
		for(int i : num1) {
			System.out.printf("%d ", i);
		}
		
		
		System.out.println();
		System.out.println("====num2====");
		for(int i : num2) {
			System.out.printf("%d ", i);
		}
	}

}
