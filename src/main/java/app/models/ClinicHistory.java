package app.models;

import java.sql.Date;

public class ClinicHistory {
	
	private Date registerDate;
	private long veterinarianId;
	private String reason;
	private String symptoms;
	private String procedure;
	private String diagnostic;
	private String medicines;
	private String dosis;
	private int orderId;
	private String vaccionationHistory;
	private String details;
	private String anulation;

	public ClinicHistory() {
		this.registerDate=new Date(System.currentTimeMillis());
	}
	

	public String getDosis() {
		return dosis;
	}


	public void setDosis(String dosis) {
		this.dosis = dosis;
	}


	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public long getVeterinarianId() {
		return veterinarianId;
	}

	public void setVeterinarianId(long veterinarianId) {
		this.veterinarianId = veterinarianId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getVaccionationHistory() {
		return vaccionationHistory;
	}

	public void setVaccionationHistory(String vaccionationHistory) {
		this.vaccionationHistory = vaccionationHistory;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAnulation() {
		return anulation;
	}

	public void setAnulation(String anulation) {
		this.anulation = anulation;
	}
	
	

}
