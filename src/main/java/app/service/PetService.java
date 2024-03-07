package app.service;

import app.dao.PersonDao;
import app.dao.PetDao;
import app.dao.petDaoimp;
import app.dto.PetDto;

public class PetService implements IPetService {
	
	private PetDao petdao;
	
	public PetService(PetDao petdao){
		this.petdao = new petDaoimp();
	}
	@Override
	public void createPet(PetDto petDto) throws Exception {
		if(petdao.findPetIfExist(petDto)) {
			throw new Exception("la mascota ya existe registrada en el sistema");
		}
		petdao.createPet(petDto);
		System.out.println("Se creo la mascota con exito");	
		
	}

}
