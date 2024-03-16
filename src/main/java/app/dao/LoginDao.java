package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PersonDto;
import app.dto.SessionDto;

public class LoginDao implements ILoginDao{
	public Connection connection = MYSQLConnection.getConnection();

	@Override
	public SessionDto login(PersonDto personDto) throws Exception {
		String query = "INSERT INTO SESSION(ROL_ID,USERNAME) VALUES (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setInt(i++, personDto.getRoleId());
		preparedStatement.setString(i++, personDto.getUsername());
		preparedStatement.execute();
		query = "SELECT ID,ROL_ID,USERNAME FROM SESSION WHERE USERNAME = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, personDto.getUsername());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			long id = resulSet.getLong("ID");
			String userRol = resulSet.getString("ROL_ID");
			String username = resulSet.getString("USERNAME");
			resulSet.close();
			preparedStatement.close();
			return new SessionDto(id, username, userRol);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

	@Override
	public void logout(long sessionId) throws Exception {
		String query = "DELETE FROM SESION WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, sessionId);
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public SessionDto findSessionById(long sessionId)throws Exception {
		String query = "SELECT ID,ROL_ID,USERNAME FROM SESION WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, sessionId);
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			long id = resulSet.getLong("ID");
			String userRol = resulSet.getString("ROL_ID");
			String username = resulSet.getString("USERNAME");
			resulSet.close();
			preparedStatement.close();
			return new SessionDto(id, username, userRol);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
}
