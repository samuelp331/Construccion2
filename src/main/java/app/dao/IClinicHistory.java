package app.dao;

import app.dto.ClinicHistoryDto;
import app.models.ClinicHistory;

public interface IClinicHistory {
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto);
	public ClinicHistory UpdateClinicHistory(ClinicHistoryDto clinichistorydto);
	 
}
