package model;

import java.util.Date;

public class UserReportData {
	private int userId;
    private String userName;
    private String productName;
    private String model;
    private String serialNo;
    private Date purchaseDate;
    private int numClaims;
    private int claimId;
    private Date dateOfClaim;
    private String description;
    private String claimStatus;
	
    public UserReportData(int userId, String userName, String productName, String model, String serialNo,
			Date purchaseDate, int numClaims, int claimId, Date dateOfClaim, String description, String claimStatus) {
		this.userId = userId;
		this.userName = userName;
		this.productName = productName;
		this.model = model;
		this.serialNo = serialNo;
		this.purchaseDate = purchaseDate;
		this.numClaims = numClaims;
		this.claimId = claimId;
		this.dateOfClaim = dateOfClaim;
		this.description = description;
		this.claimStatus = claimStatus;
	}
    
    public UserReportData() {
		this.userId = userId;
		this.userName = userName;
		this.productName = productName;
		this.model = model;
		this.serialNo = serialNo;
		this.purchaseDate = purchaseDate;
		this.numClaims = numClaims;
		this.claimId = claimId;
		this.dateOfClaim = dateOfClaim;
		this.description = description;
		this.claimStatus = claimStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getNumClaims() {
		return numClaims;
	}

	public void setNumClaims(int numClaims) {
		this.numClaims = numClaims;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public Date getDateOfClaim() {
		return dateOfClaim;
	}

	public void setDateOfClaim(Date dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	@Override
	public String toString() {
		return "UserReportData [userId=" + userId + ", userName=" + userName + ", productName=" + productName
				+ ", model=" + model + ", serialNo=" + serialNo + ", purchaseDate=" + purchaseDate + ", numClaims="
				+ numClaims + ", claimId=" + claimId + ", dateOfClaim=" + dateOfClaim + ", description=" + description
				+ ", claimStatus=" + claimStatus + "]";
	}
	
	
	
	
}
