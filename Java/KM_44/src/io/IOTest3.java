package io;

import java.io.FileReader;
import java.io.IOException;

public class IOTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader in = null;
		int ch;
		try {
			in = new FileReader("/Users/hwikun/Documents/dev/projects/SCIT/Java/KM_44/b.txt");
		} catch(IOException e) {
			System.out.println("파일이 없습니다.");
			return;
		}
		
		try {
			while(true) {
				ch =(char) in.read();
				if(ch == -1) break;
				System.out.print((char) ch);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
