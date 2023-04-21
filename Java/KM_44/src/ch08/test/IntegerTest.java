package ch08.test;


// Wrapper Class
public class IntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 100;
		String s = "123";
		
		// int -> Integer
		Integer in = new Integer(i);
		
		// String -> Integer
		Integer is = new Integer(s);
		
		// Integer -> int
		int i2 = in.intValue();
		
		// Integer -> String
		String s2 = in.toString();
		
		// int -> String
		String s3 = Integer.toString(i);
		
		// String -> int
		int i3 = Integer.parseInt(s);
		String s4 = Integer.toString(i, 16);
		System.out.println(s4);
		int i4 = Integer.parseInt("10", 16);
		System.out.println(i4);
	}

}
