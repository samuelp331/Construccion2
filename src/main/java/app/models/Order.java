package app.models;

import java.sql.Date;

public class Order {
	private int id;
	private int petId;
	private long veterinarianID;
	private long ownerId;
	private String medicine;
	private Date generationDate;
	private boolean is_canceled;
	
	public Order() {
		this.generationDate=new Date(System.currentTimeMillis());
	}

	public boolean getIs_canceled() {
		return is_canceled;
	}

	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}

	public int getId() {
		return id;
	}

	public void setId(int orderId) {
		this.id = orderId;
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
