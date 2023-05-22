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
					System.out.println("���α׷��� �����մϴ�.");
					return;
			}
		}
	}
	
	private void printMainMenu() {
		System.out.println(" [ ������ǰ �ǸŰ��� ]");
		System.out.println("1. ��ǰ ���");
		System.out.println("2. ��ǰ ��ü ����");
		System.out.println("3. �Ǹ����� ���");
		System.out.println("4. �Ǹ����� ��ü ����");
		System.out.println("5. �Ǹ����� ����");
		System.out.println("6. ��ǰ�� �Ǹ���Ȳ");
		System.out.println("0. ����");
		System.out.print("����>");
	}
	
	private void insertProduct() {
		// TODO ����ϼ���
		// ��ǰ �ڵ� : H002 / ��ǰ��: ����SSD / �ܰ�: 8000
		String code, pname;
		int price;
		
		System.out.println("[ ��ǰ ���� ��� ]");
		System.out.print("��ǰ �ڵ� : ");
		code = sc.nextLine();
		System.out.print("��ǰ�� : ");
		pname = sc.nextLine();
		System.out.print("�ܰ� : ");
		price = sc.nextInt();
		sc.nextLine();
		
		Product product = new Product(code, pname, price);
		int check = service.insertProduct(product);
		
		if(check == 1) {
			System.out.println("* ����Ǿ����ϴ�.");
		} else {
			System.out.println("* ���� �����߽��ϴ�.");
		}
	}
	
	private void selectProduct() {
		System.out.println("[ ��ǰ ���� ]");
		System.out.println("��ǰ�ڵ�\t��ǰ��\t����\t");
		System.out.println("====================================");
		ArrayList<Product> list = service.getProducts();
		if(list.size() == 0) {
			System.out.println("��ǰ�� �������� �ʽ��ϴ�!!");
		}
		for(Product item : list) {
			System.out.println(item.getCode() + "\t" + item.getPname() + "\t" + item.getPrice());
		}
	}
	
	private void insertSales() {
		// TODO ����ϼ���
		// ��ǰ�ڵ�: M001 / �Ǹż���: 2 
		System.out.println("[ �Ǹ� ���� ��� ]");
		System.out.printf("��ǰ �ڵ�: ");
		String code = sc.nextLine();
		System.out.printf("�Ǹ� ����: ");
		int quantity = Integer.parseInt(sc.nextLine());
		int check = service.createSales(new Sales(code, quantity));
		
		if(check == 1) {
			System.out.println("* ����Ǿ����ϴ�.");
		} else {
			System.out.println("* ���� �����߽��ϴ�.");
		}
	}
	
	private void selectSales() {
		System.out.println("[ �Ǹ� ���� ]");
		System.out.println("�Ϸù�ȣ\t��ǰ�ڵ�\t����\t�Ǹ���");
		System.out.println("================================================");
		ArrayList<Sales> list = service.getSales();
		if(list.size() == 0) {
			System.out.println("�Ǹ������� �������� �ʽ��ϴ�!!");
		}
		for(Sales item: list) {
			System.out.println(item.getNum() + "\t" + item.getCode() + "\t" + item.getQuantity() + "\t" + item.getInputdate());
		}
	}
	
	private void deleteSales() {
		// TODO ����ϼ���
		// ������ ��ȣ: 10
		System.out.println("[ �Ǹ� ���� ���� ]");
		System.out.printf("������ ��ȣ: ");
		int n = Integer.parseInt(sc.nextLine());
		int check = service.deleteSales(n);
		if(check == 1) {
			System.out.println("* �����Ǿ����ϴ�.");
		} else {
			System.out.println("* ���� �����߽��ϴ�.");
		}
	}
	
	private void totalSales() {
		System.out.println("[ ��ǰ�� �Ǹ� ��Ȳ ]");
		System.out.println("��ǰ�ڵ�\t\t��ǰ��\t\t����\t\t�Ǹűݾ�");
		System.out.println("==========================================");
		ArrayList<Ammount> list = service.getSalesNow();
		if(list.size() == 0) {
			System.out.println("�Ǹ���Ȳ�� �������� �ʽ��ϴ�!!");
		}
		for(Ammount item: list) {
			System.out.println(item.getCode() + "\t\t" + item.getName() + "\t\t" + item.getAmmount() + "\t\t" + item.getPrice());
		}
		
	}
}
