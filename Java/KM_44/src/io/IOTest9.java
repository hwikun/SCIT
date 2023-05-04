package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IOTest9 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Data d1 = new Data(1, 2.3, "aaa");
		Data d2 = new Data(1, 2.5, "bbbb");
		Data d3 = new Data(1, 4.4, "cccc");
		
		
		// 위 3개의 객체르로 파일에 저장
		ObjectOutputStream out = null;
		
		out = new ObjectOutputStream(new FileOutputStream("ob2.data"));
		
		out.writeObject(d1);
		out.writeObject(d2);
		out.writeObject(d3);
		
		out.close();
	}

}
