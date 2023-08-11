package com.Product.dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Product.entity.Product;







@Repository
public class ProductDao {
	@Autowired
	SessionFactory sf;
//..............inseret product........................
	public String insertProduct(List<Product> pd) {
		//System.out.println("IN Dao...."+st);
		Session session=sf.openSession();
		org.hibernate.Transaction tr=session.beginTransaction();
		
		for (Product prod : pd) {
			session.save(prod);
		}
	    tr.commit();
		
		return "Product Saved..... ";
		
	}
	//..............getProduct.......................
	public List<Product> getProduct() {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Product.class);
		return cr.list();
	}
	//........................updateproudt......................
	public String updateProduct(Product p){
		Session session=sf.openSession();
		System.out.println("dao");
		org.hibernate.Transaction tr=session.beginTransaction();
		session.update(p);
		tr.commit();
		session.close();
		return "Product Updated..............";
		
	}
	//..............................delete product.......................
	public String deleteProduct(int  pid) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
	Session session =sf.openSession();
	Transaction tr=(Transaction) session.beginTransaction();
	Product p = session.load(Product.class, pid);
	session.delete(p);
	
	tr.commit();
	session.close();
	return "product deleted ";
		
}	
}
