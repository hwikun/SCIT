
public class Exam_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] original = new String[]{"브레드", "윌크", "초코", "소세지", "치즈"};
		String[] newArr = new String[original.length];
		
		System.out.print("Original: ");
		for(String el : original) {
			System.out.printf("%s ", el);
		}
		
		System.out.println();
		
		for(int i=1; i<=original.length; i++) {
			newArr[i-1] = original[original.length-i];
		}
		
		System.out.print("New: ");
		for(String el : newArr) {
			System.out.printf("%s ", el);
		}
	}

}
