package ch03.test;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account("11-2222","나휘선", 500);
		a1.printAccountInfo();
		a1.deposit(300);
	}

}
