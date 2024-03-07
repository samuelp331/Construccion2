package app.dto;

import java.sql.Date;

import app.models.ClinicHistory;

public class ClinicHistoryDto {
	private Date registerDate;
	private long veterinarianId;
	private String reasonForConsultation;
	private String symptoms;
	private String procedures;
	private String medicines;
	private int orderId;
	private String vaccionationHistory;
	private String allergies;
	private String detailsProcedures;

	public ClinicHistoryDto(Date registerDate, long veterinarianId, String reasonForConsultation, String symptoms,
			String procedures, String medicines, int orderId, String vaccionationHistory, String allergies,
			String detailsProcedures) {
		super();
		this.registerDate = registerDate;
		this.veterinarianId = veterinarianId;
		this.reasonForConsultation = reasonForConsultation;
		this.symptoms = symptoms;
		this.procedures = procedures;
		this.medicines = medicines;
		this.orderId = orderId;
		this.vaccionationHistory = vaccionationHistory;
		this.allergies = allergies;
		this.detailsProcedures = detailsProcedures;
	}
	
	public ClinicHistoryDto(ClinicHistory clinichistory){
		this.registerDate = clinichistory.getRegisterDate();
		this.veterinarianId = clinichistory.getVeterinarianId();
		this.reasonForConsultation = clinichistory.getReasonForConsultation();
		this.symptoms = clinichistory.getSymptoms();
		this.procedures = clinichistory.getProcedures();
		this.medicines = clinichistory.getMedicines();
		this.orderId = clinichistory.getOrderId();
		this.allergies = clinichistory.getAllergies();
		this.detailsProcedures = clinichistory.getDetailsProcedures();
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

	public String getReasonForConsultation() {
		return reasonForConsultation;
	}
	public void setReasonForConsultation(String reasonForConsultation) {
		this.reasonForConsultation = reasonForConsultation;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getProcedures() {
		return procedures;
	}
	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public long getOrderId() {
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
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getDetailsProcedures() {
		return detailsProcedures;
	}
	public void setDetailsProcedures(String detailsProcedures) {
		this.detailsProcedures = detailsProcedures;
	}

}
