package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class IOTest11 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		File file, tempFile;
		BufferedWriter out = null;
		String text, filename;
		int i = 1;
		
		tempFile = new File("temp!@#$.tmp");
		out = new BufferedWriter(new FileWriter(tempFile));
		
		System.out.println("내용을 입력하세요(종료는 새 행에서 Enter)");
		while(true) {
			System.out.printf("%d: ", i++);
			text = sc.nextLine();
			if(text.isEmpty()) break;
			out.write(text);
			out.newLine(); // 줄바꾸기
		}
		out.close();
		System.out.print("저장하시겠습니까? (y/n): ");
		if(sc.nextLine().equalsIgnoreCase("n")) {
			return;
		}
		while(true) {
			System.out.printf("파일명: ");
			filename = sc.nextLine();
			file = new File(filename);
			if(!file.exists()) break;
			System.out.printf("이미 사용중인 이름입니다. 덮어쓰시겠습니까? (y/n): ");
			if(sc.nextLine().equalsIgnoreCase("y")) {
				file.delete();
				break;
			}			
		}
		tempFile.renameTo(file);
		System.out.println(filename + " 파일이 저장되었습니다");
	}

}

/*
 * 내용을 입력하세요(종료는 새 행에서 Enter)
 * 1: abcd
 * 2: 1234
 * 3: 가나다라
 * 4: 
 * 저장하시겠습니까? (y/n) y
 * 파일명: a.txt
 * 이미 사용중인 이름입니다. 덮어쓰시겠습니까? (y/n) n
 * 파일명: b.txt
 * 
 * b.txt 파일이 저장되었습니다.
 * 
 * String 이어붙이기
 * StringBuffer 사용하기
 * ArrayList 사용하기
 * 첫줄 부터 임시 파일로 저장. 저장 안한다고 하면 다 지워버리기
 * 
 */
