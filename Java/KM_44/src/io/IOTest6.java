package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class IOTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		FileOutputStream out = null;
		int i;
		String inFilename, outFilename;
		File inFile, outFile;
		Scanner sc = new Scanner(System.in);
		
		try {
			// 원본파일
			System.out.print("원본 파일명: ");
			inFilename = sc.nextLine();
			inFile = new File(inFilename);
			if(!inFile.isFile()) {
				System.out.println(inFilename + " 파일이 없습니다.");
				return;
			}
			
			in = new FileInputStream(inFilename);
			
			// 대상파일
			System.out.print("복사본 파일명: ");
			outFilename = sc.nextLine();
			outFile = new File(outFilename);
			if(outFile.isFile()) {
				System.out.println("같은 이름의 파일이 있습니다. 덮어쓰시겠습니까? (y/n)");
				if(sc.nextLine().equalsIgnoreCase("n")) return;
			}
			
			out = new FileOutputStream("a3.txt");
		
			while((i = in.read()) != -1) {
				out.write(i);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일 복사 실패");
		}
	}

}
