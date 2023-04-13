package ch05;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMaxDays(int year, int month) {
		int maxDay = 0;
		boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? true : false;
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
				maxDay = 31;
				break;
			case 4: case 6: case 9: case 11: 
				maxDay = 30;
				break;
			case 2: 
				if(isLeap) maxDay = 29;
				else maxDay = 28;
		}
		return maxDay;
	}
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean isValid() {
		if((year < 1) || (month < 1 || month > 12) || (day < 1 || day > getMaxDays(year, month))) {
			return false;
		} else {
			return true;
		}
	}
}
	

	
	

