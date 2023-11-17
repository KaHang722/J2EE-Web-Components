package model;
import java.util.Date;

public class Claims {
	private int claimId;
    private int registrationId;
    private Date dateOfClaim;
    private String description;
    private String status;
	
	public Claims(int claimId, int registrationId, Date dateOfClaim, String description, String status) {
		this.claimId = claimId;
		this.registrationId = registrationId;
		this.dateOfClaim = dateOfClaim;
		this.description = description;
		this.status = status;
	}
	
	public Claims(int registrationId, Date dateOfClaim, String description, String status) {
		this.registrationId = registrationId;
		this.dateOfClaim = dateOfClaim;
		this.description = description;
		this.status = status;
	}

	public Claims() {
		this.claimId = 0;
		this.registrationId = 0;
		this.dateOfClaim = null;
		this.description = "";
		this.status = "";
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", registrationId=" + registrationId + ", dateOfClaim=" + dateOfClaim
				+ ", description=" + description + ", status=" + status + "]";
	}

	private String updateStatus;

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }
	
	
}
