package ch08.api;

// java.lang.String 테스트
public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a;
		String b = null;
		String c = "";
		String d = "abc";
		String e = "abc";
		String f = new String("abc");
		String g = new String("abc");
		
//		System.out.println(a); // 초기화 되지 않은 상태;
		System.out.println(b); // null로 초기화가 된 상태;
		System.out.println(c); // 스트링 객체. 어딘가에 객체가 존재함.
		System.out.println(d);
		
		System.out.println(d == e);
		System.out.println(f == g);
		System.out.println(f.equals(g));
		System.out.println(f.equalsIgnoreCase("ABC"));
		
		String s = "abcdefg";
		System.out.println(s.length()); // 문자열 길이 출력
		System.out.println(s.charAt(1)); // 문자열 해당 인덱스 문자 출력;
		System.out.println(s.substring(1, 6)); // 인덱스 1번부터 5번까지 출력;
		System.out.println(s.substring(4)); // 4번부터 끝까지;
		System.out.println(s.indexOf('c')); // 해당 문자의 인덱스를 반환;
		System.out.println(s.indexOf("de")); // overloading;
		System.out.println(s.contains("ht")); // false;
		System.out.println(s.compareTo("aba")); // 유니코드 값 비교후 차이값을 반환;
		System.out.println(s.toUpperCase()); // 대문자로 변경;
		System.out.println(s.toLowerCase()); // 소문자로 변경;
		
		// 특정 문자를 뒤에서 부터 찾기;
		System.out.println("abcabcabc".lastIndexOf('c'));
		// "abc"로 시작하는가?
		System.out.println(s.startsWith("abc"));
		// "fg"로 끝나는가?
		System.out.println(s.endsWith("fg"));
		
		s = "a";
		s = s + "b";
		System.out.println(s); // 문자열 합체;
		s = "010-1111-2222";
		String s2 = s.replaceAll("-", "/"); // 문자열 변환;
		System.out.println(s2);
		String s3[] = s.split("-"); // 문자열 슬라이싱; 배열반환;
		for(int i=0; i<s3.length; i++) {
			System.out.printf("%s ",s3[i]);
		}
	}

}
