package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.ClinicHistoryDto;

public class ClinicHistoryDao implements IClinicHistory{
	
	public Connection connection = MYSQLConnection.getConnection();	

	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {

		String query = "INSERT INTO history(date,veterinarianId,reason,symptoms,"
				+ "diagnostic,procedure_pet,medicine,dosis,order_id,vaccination_history,"
				+ "detail,anulation) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setDate(i++, clinichistorydto.getRegisterDate());
		preparedStatement.setLong(i++, clinichistorydto.getVeterinarianId());
		preparedStatement.setString(i++, clinichistorydto.getReason());
		preparedStatement.setString(i++, clinichistorydto.getSymptoms());
		preparedStatement.setString(i++, clinichistorydto.getDiagnostic());
		preparedStatement.setString(i++, clinichistorydto.getProcedure());
		preparedStatement.setString(i++, clinichistorydto.getMedicines());
		preparedStatement.setString(i++, clinichistorydto.getDosis());
		preparedStatement.setInt(i++, clinichistorydto.getOrderId());
		preparedStatement.setString(i++, clinichistorydto.getVaccionationHistory());
		preparedStatement.setString(i++, clinichistorydto.getDetails());
		preparedStatement.setInt(i++, clinichistorydto.getAnulation());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		
	    String query = "UPDATE history SET date = ?, veterinarianId = ?, reason = ?,"
	    		+ " symptoms = ?, diagnostic = ?, procedure_pet = ?, medicine = ?,"
	    		+ " dosis = ?, order_id = ?, vaccination_history = ?, detail = ?,"
	    		+ " anulation = ? WHERE id = ?";

	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    	int i = 1;
	        preparedStatement.setDate(i++, clinichistorydto.getRegisterDate());
	        preparedStatement.setLong(i++, clinichistorydto.getVeterinarianId());
	        preparedStatement.setString(i++, clinichistorydto.getReason());
	    	preparedStatement.setString(i++, clinichistorydto.getSymptoms());
			preparedStatement.setString(i++, clinichistorydto.getDiagnostic());
			preparedStatement.setString(i++, clinichistorydto.getProcedure());
			preparedStatement.setString(i++, clinichistorydto.getMedicines());
			preparedStatement.setString(i++, clinichistorydto.getDosis());
			preparedStatement.setInt(i++, clinichistorydto.getOrderId());
			preparedStatement.setString(i++, clinichistorydto.getVaccionationHistory());
			preparedStatement.setString(i++, clinichistorydto.getDetails());
			preparedStatement.setInt(i++, clinichistorydto.getAnulation());
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
	}

	@Override
	public String getHistoryClinicDetails(int id) throws Exception {
		String query = "SELECT * FROM history WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		        
	    StringBuilder sb = new StringBuilder();
	    sb.append("Fecha: ").append(resultSet.getDate("date")).append("\n");
	    sb.append("Veterinario: ").append(resultSet.getLong("veterinarianId")).append("\n");
	    sb.append("Razón: ").append(resultSet.getString("reason")).append("\n");
	    
	    return sb.toString();
	}

	@Override
	public boolean existClinicHistory(int id) throws Exception {
		String query = "SELECT 1 FROM history WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean clinicHistoryExists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return clinicHistoryExists;
	}
	        
	
}
