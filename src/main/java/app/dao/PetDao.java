package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.models.Person;
import app.models.Pet;

public class PetDao implements IPetDao{
	
	public Connection connection = MYSQLConnection.getConnection();	
	@Override
	public void createPet(PetDto petDto) throws Exception {
		String query = "INSERT INTO pet(id, name,owner_id,age,species,breed,caracteristics,weight) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, petDto.getId());
		preparedStatement.setString(i++, petDto.getName());
		preparedStatement.setLong(i++, petDto.getOwnerId());
		preparedStatement.setLong(i++, petDto.getAge());
		preparedStatement.setString(i++, petDto.getSpecies());
		preparedStatement.setString(i++, petDto.getBreed());
		preparedStatement.setString(i++, petDto.getCharacteristics());
		preparedStatement.setDouble(i++, petDto.getWeight());
		preparedStatement.execute();
		preparedStatement.close();
		
	}

	@Override
	public PetDto findPetById(PetDto petDto) throws Exception {
		String query = "SELECT * FROM pet WHERE id  = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, petDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Pet pet = new Pet();
			pet.setId(resulSet.getLong("id"));
			pet.setName(resulSet.getString("name"));			
			pet.setOwnerId(resulSet.getInt("owner_id"));
			pet.setAge(resulSet.getInt("age"));
			pet.setSpecies(resulSet.getString("species"));
			pet.setBreed(resulSet.getString("breed"));
			pet.setCharacteristics(resulSet.getString("caracteristics"));
			pet.setWeight(resulSet.getDouble("weight"));
			resulSet.close();
			preparedStatement.close();
			return new PetDto(pet);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

	@Override
	public boolean findPetIfExist(PetDto petDto) throws Exception {
		String query = "SELECT * FROM pet WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, petDto.getId());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean userExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return userExists;
	}

	@Override
	public PetDto findPetByName(PetDto petDto) throws Exception {
		String query = "SELECT * FROM pet WHERE name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, petDto.getName());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			Pet pet = new Pet();
			pet.setId(resulSet.getLong("id"));
			pet.setName(resulSet.getString("name"));			
			pet.setOwnerId(resulSet.getInt("owner_id"));
			pet.setAge(resulSet.getInt("age"));
			pet.setSpecies(resulSet.getString("species"));
			pet.setBreed(resulSet.getString("breed"));
			pet.setCharacteristics(resulSet.getString("caracteristics"));
			pet.setWeight(resulSet.getDouble("weight"));
			resulSet.close();
			preparedStatement.close();
			return new PetDto(pet);
		}
		return null;
	}

}
