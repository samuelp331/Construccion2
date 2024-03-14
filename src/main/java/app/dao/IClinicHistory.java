package app.dao;

import app.dto.ClinicHistoryDto;
import app.models.ClinicHistory;

public interface IClinicHistory {
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public String consultMedicalHistoryById(int id) throws Exception;
}
