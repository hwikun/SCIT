package ch08.test;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int I요일 = c.get(Calendar.DAY_OF_WEEK);
		String ampm = c.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		String 요일 = "";
		
		switch(I요일) {
		 case 1: 요일 = "일"; break;
		 case 2: 요일 = "월"; break;
		 case 3: 요일 = "화"; break;
		 case 4: 요일 = "수"; break;
		 case 5: 요일 = "목"; break;
		 case 6: 요일 = "금"; break;
		 case 7: 요일 = "토"; break;
		 
		}
		
		// 2023년 4월 20일 목요일 오후 5시 42분 45초입니다.
		System.out.printf("%d년 %d월 %d일 %s요일, %s %d시 %d분 %d초입니다.", year, month, date, 요일, ampm, hour, minute, sec);
	}

}
