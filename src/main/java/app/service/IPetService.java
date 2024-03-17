package app.service;

import app.dto.PetDto;

public interface IPetService {
	public void createPet(PetDto petDto) throws Exception;
}
