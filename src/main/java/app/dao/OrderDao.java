package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.OrderDto;

public class OrderDao implements IOrderDao {
	
	public Connection connection = MYSQLConnection.getConnection();	

	@Override
	public int createOrder(OrderDto orderdto)  throws Exception {
		String query = "INSERT INTO pet_order(pet_id,owner_id,veterinarian_id,medicine,"
				+ "date,is_canceled) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setInt(i++, orderdto.getPetId());
		preparedStatement.setLong(i++, orderdto.getOwnerId());
		preparedStatement.setLong(i++, orderdto.getVeterinarianID());
		preparedStatement.setString(i++, orderdto.getMedicine());
		preparedStatement.setDate(i++, orderdto.getGenerationDate());
		preparedStatement.setBoolean(i++, orderdto.getIs_canceled());
		preparedStatement.execute();
		preparedStatement.close();
		
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
	    int orderId = -1; 
	    if (resultSet.next()) {
	        orderId = resultSet.getInt(1);
	    }

	    resultSet.close();
	    preparedStatement.close();

	    return orderId;
	}

	@Override
	public void cancelOrder(int id) throws Exception{
		
	   String query = "UPDATE pet_order SET is_canceled = 1 WHERE id = ?";
	   PreparedStatement preparedStatement = connection.prepareStatement(query);
	   preparedStatement.setInt(1, id);
	   preparedStatement.executeUpdate();
	}

	@Override
	public String seeOrder(int id) throws Exception {
		String query = "SELECT * FROM pet_order WHERE id = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.isBeforeFirst()) {
		    StringBuilder sb = new StringBuilder();
		    while(resultSet.next()) {
		        sb.append("Fecha: ").append(resultSet.getDate("date")).append("\n");
		        sb.append("Veterinario: ").append(resultSet.getLong("veterinarian_id")).append("\n");
		        sb.append("Medicinas: ").append(resultSet.getString("medicine")).append("\n");
		    }
		    return sb.toString();
		} else {
		    return "No se encontraron resultados";
		}

	    
	}
	
}
