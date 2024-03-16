package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.models.Person;

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
		
		return null;
	}
	
	
	@Override
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT * FROM person WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUsername());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Person person = new Person();
			person.setId(resulSet.getLong("ID"));
			person.setFullName(resulSet.getString("NAME"));
			person.setRoleId(resulSet.getInt("ID_ROL"));
			person.setUsername(resulSet.getString("USERNAME"));
			person.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return new PersonDto(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
	
	@Override
	public boolean existUserByUserName(PersonDto personDto) throws Exception {
		String query = "SELECT * FROM person WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUsername());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}


}
