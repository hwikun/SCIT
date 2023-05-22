package shop.service;

import java.util.ArrayList;

import shop.dao.ShopDAO;
import shop.vo.Ammount;
import shop.vo.Product;
import shop.vo.Sales;

public class ShopService {

	private ShopDAO dao = new ShopDAO();
	
	public int insertProduct(Product product) {
		return dao.insertProduct(product);
	}
	
	public ArrayList<Product> getProducts() {
		// TODO select Products
		ArrayList<Product> list = dao.getProducts();
		return list;
	}

	public int createSales(Sales sales) {
		// TODO insert Sales
		return dao.insertSales(sales);
	}

	public ArrayList<Sales> getSales() {
		// TODO get Sales list
		ArrayList<Sales> list = dao.selectSales();
		return list;
	}

	public int deleteSales(int n) {
		// TODO delete Sales
		Sales s = dao.findOneSales(n);
		if(s != null) {
			return dao.deleteSales(n);
		}
		return 0;
	}

	public ArrayList<Ammount> getSalesNow() {
		// TODO get list of product code, name and sale count, sum of price
		ArrayList<Ammount> list = dao.getAmmounts();
		return list;
	}



	
	

}
