package app.dao;

import app.dto.PetDto;

public interface PetDao {
	public void createPet(PetDto petDto) throws Exception;
	public boolean findPetIfExist(PetDto personDto)throws Exception;
	public PetDto findPetById(PetDto personDto) throws Exception;
}
