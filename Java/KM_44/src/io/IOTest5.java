package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		String s;
		
		try {
			br = new BufferedReader(new FileReader
					("/Users/hwikun/Documents/dev/projects/SCIT/Java/KM_44/b.txt"));
		} catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다");
			return;
		}
		try {
			while(true) {
				s = br.readLine();
				if(s == null) break;
				System.out.println(s);
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
