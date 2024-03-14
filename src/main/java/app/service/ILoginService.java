package app.service;

import app.dto.PersonDto;

public interface ILoginService {
	public void setSesionID(long sesionId);
	public void login(PersonDto personDto)throws Exception;	
	public void logout() throws Exception;
}
