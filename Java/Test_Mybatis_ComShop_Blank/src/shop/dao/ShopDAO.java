package shop.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import shop.vo.Ammount;
import shop.vo.Product;
import shop.vo.Sales;

public class ShopDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public int insertProduct(Product product) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			cnt = mapper.insertProduct(product);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	public ArrayList<Product> getProducts() {
		// TODO get Product list
		SqlSession session = null;
		ArrayList<Product> list = null;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			list = mapper.selectProducts();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	public int insertSales(Sales sales) {
		// TODO insertSales
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			cnt = mapper.insertSales(sales);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	public ArrayList<Sales> selectSales() {
		// TODO get list of Sales
		SqlSession session = null;
		ArrayList<Sales> list = null;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			list = mapper.selectSales();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	public Sales findOneSales(int n) {
		// TODO get one Sales
		SqlSession session = null;
		Sales s = null;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			s = mapper.selectOneSales(n);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return s;
	}

	public int deleteSales(int n) {
		// TODO delete one sales
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			cnt = mapper.deleteSales(n);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	public ArrayList<Ammount> getAmmounts() {
		// TODO get code name count sum of price
		
		SqlSession session = null;
		ArrayList<Ammount> list = null;
		
		try {
			session = factory.openSession();
			ShopMapper mapper = session.getMapper(ShopMapper.class);
			list = mapper.selectAmmount();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}
	

}
