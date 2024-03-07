package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;

public class PersonDaoImp implements PersonDao {

	public Connection connection = MYSQLConnection.getConnection();	
	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findUserExist(PersonDto personDto) throws Exception {
		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, personDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PersonDto findUserById(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
