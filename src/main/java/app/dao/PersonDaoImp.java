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
		// TODO Auto-generated method stub
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
			person.setId(resulSet.getLong("id"));
			person.setName(resulSet.getString("name"));
			person.setRoleId(resulSet.getInt("id_rol"));
			person.setUsername(resulSet.getString("username"));
			person.setPassword(resulSet.getString("password"));
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
