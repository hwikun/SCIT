package ch03.test;

public class Account {
	String accNo; // 계좌번호
	String owner; // 예금주
	private long balance; // 잔액
	
	// 생성자
	public Account(String accNo, String owner, long balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	// 입금 메소드
	public void deposit(long amount) {
		balance += amount;
		System.out.println("a1 계좌에 300 입금");
		printAccountInfo();
	}
	
	// 잔고 조회 메소드
	public long getBalance() {
		return balance;
	}
	
	// 출금 메소드
	public String withdraw(long amount) {
		balance -= amount;
		return "출금되었습니다";
	}
	
	// 계좌정보 출력
	public void printAccountInfo() {
		System.out.println("계좌번호: "+ accNo + "\n예금주: "+ owner + "\n잔액"+ balance);
	}
}
