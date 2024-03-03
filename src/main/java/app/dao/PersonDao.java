package app.dao;

import app.dto.PersonDto;

public interface PersonDao {
	public void createPerson(PersonDto personDto) throws Exception;
	public boolean findUserExist(PersonDto personDto)throws Exception;
	public PersonDto findUserById(PersonDto personDto) throws Exception;
	public PersonDto findRolById(PersonDto personDto) throws Exception;
}
