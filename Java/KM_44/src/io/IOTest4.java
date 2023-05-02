package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		File file = null;
		FileReader in = null;
		int ch;
		while(true) {
			System.out.printf("읽을 파일: ");
			try {
				file = new File(sc.nextLine());
				break;
			} catch(NullPointerException e) {
				e.printStackTrace();
				System.out.println("파일이 없습니다. 다시 입력하세요.");
				continue;
			}
		}
		try {
			in = new FileReader(file);
			while((ch = in.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일 읽기 실패");
		}
	}
}
/*
 * 읽을 파일 :c:\aaa.txt
 * 파일이 없습니다. 다시 입력하세요.
 * 읽을 파일: c:\Test\aaa.txt
 * ======읽은 내용 출력======
 * 총 xxx bytes
 */