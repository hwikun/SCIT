package io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class IOTest10 {

	public static void main(String[] args) throws Exception {
		Data d;
		ObjectInputStream in;
		in = new ObjectInputStream(new FileInputStream("ob2.data")); // 객체단위로
		
		
		try {
			while(true) {
				d = (Data) in.readObject();
				System.out.println(d);
			}
		} catch(EOFException e) {}
		
		in.close();
	}

}
