package ch06.bank;

public class AccountTest {

	public static final String BANK_NO = "123";
	public static final String AREA_NO = "0045";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a1 = new Account(AccountIDGen.genAccID(BANK_NO, AREA_NO), "김철수", 10000);
		Account a2 = new Account(AccountIDGen.genAccID(BANK_NO, AREA_NO), "홍길동", 10000);
		deposit(a1, 10000); // 입금
		transfer(a1, a2, 5000); // 이체 5000원, 성공;
		transfer(a1, a2, 20000); // 이체 20000원, 실패;
	}
	
	// UI에 해당하는 부분
	public static void deposit(Account acc, long amount) {
		acc.deposit(amount);
		System.out.println("============[입금]============");
		System.out.printf("%s 계좌에 %d원이 입금되었습니다.\n", acc.getAccNo(), amount);
		System.out.printf("현재 잔고는 %d원 입니다\n", acc.getBalance());
		System.out.println("=============================");
	}
	
	public static void transfer(Account from, Account to, long amount) {
		if(from.transfer(to, amount)) { // if문 조건식에 넣어도 메소드 실행 가능.
			System.out.println("============[송금]============");
			System.out.printf("%s님 계좌에서 %s님 계좌로 %d원이 송금처리 되었습니다.\n", from.getCustomer(), to.getCustomer(), amount);
			System.out.printf("현재 잔고는 %d원 입니다\n", from.getBalance());
			System.out.println("=============================");
		} else {
			System.out.println("============[송금]============");
			System.out.printf("%d원 송금에 실패하였습니다. 잔액을 확인해주세요.\n", amount);
			System.out.printf("현재 잔고는 %d원 입니다\n", from.getBalance());
			System.out.println("=============================");
		}
	}
}
