package ch09;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		list.add("aaa"); // 추가
		list.add("bbb");
		list.add("ccc");
		System.out.println(list);
		System.out.println(list.size()); // 값이 들어있는 길이 출력.
		System.out.println(list.isEmpty()); // size가 0인지 확인후 boolean출력
		
		list.add(1, "ddd"); // 해당 인덱스에 추가
		System.out.println(list);
		list.set(1, "xxx"); // 수정
		System.out.println(list);
		
		System.out.println(list.get(0)); // 요소 출력
		System.out.println(list.remove(0)); // 출력 후 제거
		System.out.println(list.contains("ccc")); // 포함 여부 boolean 출력
		System.out.println(list.indexOf("ccc")); // 포함 인덱스 출력
//		for(int i=0; i<list.size(); i++) {
//			System.out.printf("%d - %s\n", i+1, list.get(i));
//		}
//		
//		for(String s : list) {
//			System.out.printf("%d - %s\n",list.indexOf(s) +1, s);
//		}
		list.forEach(item -> System.out.printf("%d - %s\n", list.indexOf(item)+1, item));
		
		
	}

}
