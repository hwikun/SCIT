package shop.dao;

import java.util.ArrayList;

import shop.vo.Ammount;
import shop.vo.Product;
import shop.vo.Sales;

public interface ShopMapper {

	public int insertProduct(Product product);

	public ArrayList<Product> selectProducts();

	public int insertSales(Sales sales);

	public int findOneProduct(String code);

	public ArrayList<Sales> selectSales();

	public Sales selectOneSales(int n);

	public int deleteSales(int n);

	public ArrayList<Ammount> selectAmmount();

}
