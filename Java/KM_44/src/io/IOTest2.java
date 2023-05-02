package io;

import java.io.FileWriter;
import java.io.IOException;

// 텍스트파일 출력
public class IOTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter out = null; // 파일 출력, 문자로
		
		try {
			// 스트림 생성
			out = new FileWriter("b.txt");
			
			// 입출력 작업
			out.write("A");
			out.write("가");  // 예외처리 필수
			out.write("\n");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일 생성 실패");
			return;
		}
		
		// 스트림 닫기
		try {
			out.close(); // 예외처리 무조건 필
		} catch (IOException e) {
			System.out.println("파일 닫기 오류");
		}
	}

}
