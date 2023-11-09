package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductsById(@PathVariable int id) {
		return productService.getProductbyId(id);
	}
	
	@PostMapping("/products")
	public String addProducts(@RequestBody Product product) {
		productService.addProduct(product);
		return "Product is Added";
	}
	
	@DeleteMapping("/products/{id}")
	public String removeProducts(@PathVariable int id) {
		productService.deleteProduct(id);
		return "Product is Deleted";
	}
	
	@PutMapping("/products")
	public String updateProducts(@RequestBody Product product) {
		productService.updateProduct(product);
		return "Product is updated";
		
	}

}
