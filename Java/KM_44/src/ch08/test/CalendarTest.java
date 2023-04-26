package ch08.test;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		String ampm = c.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		String names[] = {"일", "월", "화", "수", "목", "금", "토"};
		String day = names[c.get(Calendar.DAY_OF_WEEK) -1];
		
		
		// 2023년 4월 20일 목요일 오후 5시 42분 45초입니다.
		System.out.printf("%d년 %d월 %d일 %s요일, %s %d시 %d분 %d초입니다.", year, month, date, day, ampm, hour, minute, sec);
	}

}
