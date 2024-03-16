package app.service;

import app.dto.ClinicHistoryDto;

public interface IClinicHistoryService {
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception;
	public String getHistoryClinicDetails(int id) throws Exception; 
}
