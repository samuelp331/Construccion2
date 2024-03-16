package app.dto;

import java.sql.Date;

import app.models.ClinicHistory;

public class ClinicHistoryDto {
	
	private int id;
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

	public ClinicHistoryDto(int id,Date registerDate, long veterinarianId, String reason, String symptoms, String procedure,
			String diagnostic, String medicines, String dosis, int orderId, String vaccionationHistory, String details,
			String anulation) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.veterinarianId = veterinarianId;
		this.reason = reason;
		this.symptoms = symptoms;
		this.procedure = procedure;
		this.diagnostic = diagnostic;
		this.medicines = medicines;
		this.orderId = orderId;
		this.vaccionationHistory = vaccionationHistory;
		this.details = details;
		this.anulation = anulation;
		this.dosis = dosis;
	}

	public ClinicHistoryDto(ClinicHistory clinichistory){
		this.id = clinichistory.getId();
		this.registerDate = clinichistory.getRegisterDate();
		this.veterinarianId = clinichistory.getVeterinarianId();
		this.reason = clinichistory.getReason();
		this.symptoms = clinichistory.getSymptoms();
		this.procedure = clinichistory.getProcedure();
		this.diagnostic = clinichistory.getMedicines();
		this.medicines = clinichistory.getMedicines();
		this.dosis = clinichistory.getDosis();
		this.orderId = clinichistory.getOrderId();
		this.vaccionationHistory = clinichistory.getVaccionationHistory();
		this.details = clinichistory.getDetails();
		this.anulation = clinichistory.getAnulation();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
