package com.example.demo.entity;

public class Product {
	private int id;
	private String name;
	private String barcode;
	
	public Product(int id, String name, String barcode) {
		super();
		this.id = id;
		this.name = name;
		this.barcode = barcode;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	
	

}
