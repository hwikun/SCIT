package shop.ui;

import java.util.ArrayList;
import java.util.Scanner;

import shop.service.ShopService;
import shop.vo.Ammount;
import shop.vo.Product;
import shop.vo.Sales;

public class ShopUI {
	
	private Scanner sc = new Scanner(System.in);
	private ShopService service = new ShopService();
	
	public ShopUI() {
		while (true) {
			printMainMenu();
			String menu = sc.nextLine();
			
			switch (menu) {
				case "1":
					insertProduct();
					break;
				case "2":
					selectProduct();
					break;
				case "3":
					insertSales();
					break;
				case "4":
					selectSales();
					break;
				case "5":
					deleteSales();
					break;
				case "6":
					totalSales();
					break;
				case "0":
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		}
	}
	
	private void printMainMenu() {
		System.out.println(" [ 전자제품 판매관리 ]");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 전체 보기");
		System.out.println("3. 판매정보 등록");
		System.out.println("4. 판매정보 전체 보기");
		System.out.println("5. 판매정보 삭제");
		System.out.println("6. 상품별 판매현황");
		System.out.println("0. 종료");
		System.out.print("선택>");
	}
	
	private void insertProduct() {
		// TODO 사용하세요
		// 상품 코드 : H002 / 상품명: 외장SSD / 단가: 8000
		String code, pname;
		int price;
		
		System.out.println("[ 상품 정보 등록 ]");
		System.out.print("상품 코드 : ");
		code = sc.nextLine();
		System.out.print("상품명 : ");
		pname = sc.nextLine();
		System.out.print("단가 : ");
		price = sc.nextInt();
		sc.nextLine();
		
		Product product = new Product(code, pname, price);
		int check = service.insertProduct(product);
		
		if(check == 1) {
			System.out.println("* 저장되었습니다.");
		} else {
			System.out.println("* 저장 실패했습니다.");
		}
	}
	
	private void selectProduct() {
		System.out.println("[ 상품 정보 ]");
		System.out.println("상품코드\t상품명\t가격\t");
		System.out.println("====================================");
		ArrayList<Product> list = service.getProducts();
		if(list.size() == 0) {
			System.out.println("상품이 존재하지 않습니다!!");
		}
		for(Product item : list) {
			System.out.println(item.getCode() + "\t" + item.getPname() + "\t" + item.getPrice());
		}
	}
	
	private void insertSales() {
		// TODO 사용하세요
		// 상품코드: M001 / 판매수량: 2 
		System.out.println("[ 판매 정보 등록 ]");
		System.out.printf("상품 코드: ");
		String code = sc.nextLine();
		System.out.printf("판매 수량: ");
		int quantity = Integer.parseInt(sc.nextLine());
		int check = service.createSales(new Sales(code, quantity));
		
		if(check == 1) {
			System.out.println("* 저장되었습니다.");
		} else {
			System.out.println("* 저장 실패했습니다.");
		}
	}
	
	private void selectSales() {
		System.out.println("[ 판매 정보 ]");
		System.out.println("일련번호\t상품코드\t수량\t판매일");
		System.out.println("================================================");
		ArrayList<Sales> list = service.getSales();
		if(list.size() == 0) {
			System.out.println("판매정보가 존재하지 않습니다!!");
		}
		for(Sales item: list) {
			System.out.println(item.getNum() + "\t" + item.getCode() + "\t" + item.getQuantity() + "\t" + item.getInputdate());
		}
	}
	
	private void deleteSales() {
		// TODO 사용하세요
		// 삭제할 번호: 10
		System.out.println("[ 판매 정보 삭제 ]");
		System.out.printf("삭제할 번호: ");
		int n = Integer.parseInt(sc.nextLine());
		int check = service.deleteSales(n);
		if(check == 1) {
			System.out.println("* 삭제되었습니다.");
		} else {
			System.out.println("* 삭제 실패했습니다.");
		}
	}
	
	private void totalSales() {
		System.out.println("[ 상품별 판매 현황 ]");
		System.out.println("상품코드\t\t상품명\t\t수량\t\t판매금액");
		System.out.println("==========================================");
		ArrayList<Ammount> list = service.getSalesNow();
		if(list.size() == 0) {
			System.out.println("판매현황이 존재하지 않습니다!!");
		}
		for(Ammount item: list) {
			System.out.println(item.getCode() + "\t\t" + item.getName() + "\t\t" + item.getAmmount() + "\t\t" + item.getPrice());
		}
		
	}
}
