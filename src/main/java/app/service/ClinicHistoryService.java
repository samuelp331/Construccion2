package app.service;

import app.dto.ClinicHistoryDto;
import app.dao.ClinicHistoryDao;

public class ClinicHistoryService implements IClinicHistoryService {
	
	private ClinicHistoryDao clinichistorydao;
	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		
		clinichistorydao.CreateClinicHistory(clinichistorydto);
		System.out.println("Se creo la historia clinica" + clinichistorydto.getDetails());	
		
	}

	@Override
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		
		if(clinichistorydao.existClinicHistory(clinichistorydto.getId())){
			clinichistorydao.UpdateClinicHistory(clinichistorydto);
			System.out.println("Se actualizo la historia clinica" + clinichistorydto.getDetails());	
		}	
		
	}

	@Override
	public String getHistoryClinicDetails(int id) throws Exception {
		String details = "";
		if(clinichistorydao.existClinicHistory(id)){
			details = clinichistorydao.getHistoryClinicDetails(id);
		}else {
			details = "La historia clinica no existe";
		}
		return details;
	}

}
