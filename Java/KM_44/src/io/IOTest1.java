package io;

import java.io.File;
import java.io.IOException;

public class IOTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File a = new File("a.text");
		File b = new File("sub");
		System.out.println(a.exists()); // 있는지 없는지
		System.out.println(a.isFile()); // 파일인지 아닌지
		System.out.println(a.isDirectory()); // 폴더인지 아닌지
		
		// 파일 생성하기
		try {
			a.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File c = new File("/Users/hwikun/Documents/dev/projects/SCIT/Java/school/src/vo/Student.java");
		System.out.println(c.isFile()); // true
		System.out.println(c.getName());  //Student.java
		System.out.println(c.getParent()); 
		System.out.println(c.length()); // 1388
		
		File d = new File("/Users/hwikun/Documents/dev/projects/ahtti");
		String fileNames[] = d.list();  // 이름 리스트
		File files[] = d.listFiles(); // 파일리스트
		for(String el : fileNames) {
			System.out.println(el);
		}
		for(File el : files) {
			System.out.println(el.isFile());
		}
		
		// 현재위치 알아내기
		File e = new File(".");
		try {
			System.out.println(e.getCanonicalPath());
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		// 파일명 변경하기
		File f = new File("a2.txt");
		a.renameTo(f);
		
		// 파일 삭제하기
		f.delete();
	}

}
