package app.models;

import java.sql.Date;

public class Order {
	private int orderId;
	private int petId;
	private long veterinarianID;
	private long ownerId;
	private String medicine;
	private Date generationDate;
	
	public Order() {
		this.generationDate=new Date(System.currentTimeMillis());
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public long getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(long veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}
	
	

}
