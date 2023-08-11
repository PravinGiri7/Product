package com.Product.controller;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Product.entity.Product;
import com.Product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	//...........insertproduct........................
	@PostMapping("addproduct")
	public String insertProduct(@RequestBody List<Product> pd) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		System.out.println("controller");
		return service.insertProduct(pd);
	}
	
	
	//.......GettingallProduct....................
	@GetMapping("/getProduct")
	public List<Product> getProduct() {
		return service.getProduct();
	}
	
	@PutMapping("/updatepr")
	String updateProduct(@RequestBody Product p) {
		System.out.println("Contoller");
		return service.updateProduct(p);
	}
	
	@DeleteMapping("/deletepd/{pid}")
	String deleteProduct(@PathVariable int  pid) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		System.out.println("controller");
		return service.deleteProduct(pid);
	}

}
