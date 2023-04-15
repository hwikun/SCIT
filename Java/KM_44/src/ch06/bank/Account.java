package ch06.bank;

public class Account {
	private String accNo;
	private String customer;
	private long balance;
	
	public Account(String accNo, String customer, long balance) {
		this.accNo = accNo;
		this.customer = customer;
		this.balance = balance;
	}
	
	// 잔고가 0원인 계좌를 만들때의 생성자
	public Account(String accNo, String customer) {
		this(accNo, customer, 0);
	}

	// getter & setter
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAccNo() {
		return accNo;
	}

	public long getBalance() {
		return balance;
	}
	
	// 입금
	public void deposit(long amount) {
		balance += amount;
	}
	
	// 출금
	public boolean withdraw(long amount) {
		boolean result = false;
		if(balance >= amount) {
			balance -= amount;
			result = true;
		}
		return result;
	}
	
	// 이체
	public boolean transfer(Account acc, long amount) {
		boolean result = false;
		if(withdraw(amount)) {
			acc.deposit(amount);
			result = true;
		}
		return result;
	}
	
	// 이체 계좌번호(스트링)
	public boolean transferAccNo(String accNo, long amount) {
		boolean result = false;
		if(balance >= amount /* && 입력한 계좌번호가 상대방의 계좌번호가 일치하면)*/) {
			// 그 계좌번호로 deposit(amount); // 상대방 계좌에 입금
			withdraw(amount); //내통장에서 출금
			result = true;
		}
		return result;
	}
	
	public void printAccInfo() {
		System.out.printf("계좌번호: %s, 예금주: %s, 잔고: %d\n", accNo, customer, balance);
	}
}
