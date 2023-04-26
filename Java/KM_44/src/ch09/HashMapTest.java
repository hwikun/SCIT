package ch09;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "SCIT");
		map.put(2, "AAAA");
		map.put(3, "BBBB");
		map.put(4, "CCCC");
		
		System.out.println(map.get(10));

	}

}
