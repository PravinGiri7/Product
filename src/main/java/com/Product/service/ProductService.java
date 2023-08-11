package com.Product.service;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Product.dao.ProductDao;
import com.Product.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao dao;
	public String insertProduct(List<Product> pd) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		System.out.println("service");
		return dao.insertProduct(pd);
	}
	public List<Product> getProduct() {
		return dao.getProduct();
	}
	
	public String updateProduct(Product p) {
		System.out.println("Service");
		return dao.updateProduct(p);
	}
	public String deleteProduct(int  pid) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		System.out.println("service");
		return dao.deleteProduct(pid);
	}

}
