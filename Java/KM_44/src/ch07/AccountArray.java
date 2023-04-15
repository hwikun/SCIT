package ch07;

import ch06.bank.Account;

public class AccountArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc [] = new Account[3];
		acc[0] = new Account("11-11", "홍길동", 500);
		acc[0].printAccInfo();
	}

}
