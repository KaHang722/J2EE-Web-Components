package model;

public class Products {
	private int productID;
	private String productName,model;
	
	public Products(int productID, String productName, String model) {
		this.productID = productID;
		this.productName = productName;
		this.model = model;
	}
	
	public Products(String productName, String model) {
		this.productName = productName;
		this.model = model;
	}

	public Products() {
		this.productID = 0;
		this.productName = "";
		this.model = "";
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName=" + productName + ", model=" + model + "]";
	}


	
	
}
