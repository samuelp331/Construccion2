package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.config.MYSQLConnection;
import app.dto.OrderDto;

public class OrderDao implements IOrderDao {
	
	public Connection connection = MYSQLConnection.getConnection();	

	@Override
	public void createOrder(OrderDto orderdto)  throws Exception {
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
		
	}

	@Override
	public boolean cancelOrder(int id) throws Exception{
		
	   String query = "UPDATE pet_order SET is_canceled = 1 WHERE id = ?";
	   PreparedStatement preparedStatement = connection.prepareStatement(query);
	   preparedStatement.setInt(1, id);
	   int rowsAffected = preparedStatement.executeUpdate();
	   if(rowsAffected > 0) {
		   return true;
	   }
	   return false;
	}
	
}
