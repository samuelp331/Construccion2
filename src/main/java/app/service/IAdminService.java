package app.service;

import app.dto.PersonDto;

public interface IAdminService {
	public void createUser(PersonDto personDto) throws Exception;
}
