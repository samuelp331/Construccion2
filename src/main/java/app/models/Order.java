package app.models;

import java.sql.Date;

public class Order {
	private int orderId;
	private int petId;
	private int ownerId;
	private String nameMedications;
	private Date generationDate;
	
	public Order() {
		this.generationDate=new Date(System.currentTimeMillis());
	}
	
	public long getOrderId() {
		return orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getNameMedications() {
		return nameMedications;
	}
	public void setNameMedications(String nameMedications) {
		this.nameMedications = nameMedications;
	}
	public Date getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

}
