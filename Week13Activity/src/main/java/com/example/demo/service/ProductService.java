package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	List<Product> products = new ArrayList<>();
	
	public ProductService() {
		products.add(new Product(1, "Paper", "12345"));
		products.add(new Product(2, "Pen", "12346"));
	}
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public Product getProductbyId(int id) {
		for(Product product:products )
		{
			if (product.getId()==id)
				return product;
		}
		return null;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void deleteProduct(int id) {
		int index =0;
		for(Product product: products) {
			if (product.getId()==id) {
				break;
			}
			index++;
		}
		products.remove(index);
	}
	
	public void updateProduct(Product pd) {
		int index =0;
		
		for(Product product : products) {
			if(product.getId()==pd.getId()) {
				break;
			}
			index++;
		}
		products.remove(index);
		products.add(index, pd);
	}
	

}
