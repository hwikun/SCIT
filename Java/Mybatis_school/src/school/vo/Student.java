package school.vo;

public class Student extends Person {
	private static final long serialVersionUID = 3929783946063331128L;
	private int kor, eng, mat;
	
	public Student() {
		super();
	}

	public Student(String id, String name, String phone, int kor, int eng, int mat) {
		super(id, name, phone);
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	
	// 총점
	public int getTotal() {
		return kor + eng + mat;
	}
	
	// 평균
	public double getAvg() {
		return getTotal() / 3.0;
	}
	
	// 학점
	public char getGrades() {
		double avg = getAvg();
		if(avg > 90) return 'A';
		else if(avg > 80) return 'B';
		else if (avg > 70) return 'C';
		else if (avg > 60) return 'D';
		else return 'F';
	}
	
	// toString() Override;
	@Override
	public String toString() {
		String a = super.toString();
		String b = "\n국어점수: " + kor + "\n영어점수: " 
				+ eng + "\n수학점수: " + mat +  "\n합계: " + getTotal() + "\n평균: " + getAvg() + "\n등급: " + getGrades();
		return a + b;
	}
}
