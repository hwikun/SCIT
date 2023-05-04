package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


// 메모리에서 파일로
public class IOTest7 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaaaa");
		list.add("Bbbb");
		list.add("CCCC");
		
		ObjectOutputStream out = null;
		
		out = new ObjectOutputStream(new FileOutputStream("ob.data"));
		
		out.writeObject(list);
		out.close();
		
		
	}

}
