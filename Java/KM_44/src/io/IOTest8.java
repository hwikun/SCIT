package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// 파일에서 메모리로

public class IOTest8 {

	public static void main(String[] args) throws Exception {
		ArrayList<String> arr;
		ObjectInputStream in;
		
		in = new ObjectInputStream(new FileInputStream("ob.data"));	
		arr = (ArrayList<String>) in.readObject();
		
		System.out.println(arr);
	}

}
