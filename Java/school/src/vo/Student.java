package vo;

public class Student extends Person {
	private static final long serialVersionUID = 3929783946063331128L;
	private int lanScore, matScore, engScore;
	
	public Student() {
		super();
	}

	public Student(String name, String id, String phone, int lanScore, int matScore, int engScore) {
		super(name, id, phone);
		this.lanScore = lanScore;
		this.matScore = matScore;
		this.engScore = engScore;
	}

	public int getLanScore() {
		return lanScore;
	}

	public void setLanScore(int lanScore) {
		this.lanScore = lanScore;
	}

	public int getMatScore() {
		return matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	// 총점
	public int getTotal() {
		return lanScore + engScore + matScore;
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
		String b = "\n국어점수: " + lanScore + "\n수학점수: " + matScore + "\n영어점수: " 
		+ engScore + "\n합계: " + getTotal() + "\n평균: " + getAvg() + "\n등급: " + getGrades();
		return a + b;
	}
}
