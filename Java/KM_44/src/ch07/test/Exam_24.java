package ch07.test;

public class Exam_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[10]; 
		
		System.out.printf("변경 전: ");
		for(int i=0; i<10; i++) {
			char newChar = (char)((Math.random()*26) + 65);
			arr[i] = newChar;
			System.out.printf("%c", arr[i]);
		}
		System.out.println();
		System.out.printf("변경 후: ");
		for(char el : arr) {
			if((el >= 'A' && el <= 'F') || (el >= 'Q' && el <= 'Z')) {
				el = '*';
			}
			System.out.printf("%c", el);
		}
		
	}

}
