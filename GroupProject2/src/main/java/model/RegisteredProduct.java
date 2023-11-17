package model;

import java.util.Date;

public class RegisteredProduct {
	private int registrationId;
    private int userId;
    private int productId;
    private String serialNo;
    private Date purchaseDate;
	
	public RegisteredProduct(int registrationId, int userId, int productId, String serialNo, Date purchaseDate) {
		this.registrationId = registrationId;
		this.userId = userId;
		this.productId = productId;
		this.serialNo = serialNo;
		this.purchaseDate = purchaseDate;
	}
	
	public RegisteredProduct(int userId, int productId, String serialNo, Date purchaseDate) {
		this.userId = userId;
		this.productId = productId;
		this.serialNo = serialNo;
		this.purchaseDate = purchaseDate;
	}

	public RegisteredProduct() {
		this.registrationId = 0;
		this.userId = 0;
		this.productId = 0;
		this.serialNo = "";
		this.purchaseDate = null;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "RegisteredProduct [registrationId=" + registrationId + ", userId=" + userId + ", productId=" + productId
				+ ", serialNo=" + serialNo + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
