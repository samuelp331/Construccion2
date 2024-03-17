package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.config.MYSQLConnection;
import app.dto.BillDto;

public class SailDao implements ISailDao {
	
	public Connection connection = MYSQLConnection.getConnection();	
	@Override
	public void createSale(BillDto billDto) throws Exception {
		String query = "INSERT INTO bill(pet_id,owner_id,order_id,product_name,"
				+ "value,amount,date) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setInt(i++, billDto.getPetId());
		preparedStatement.setLong(i++, billDto.getOwnerId());
		preparedStatement.setInt(i++, billDto.getOrderId());
		preparedStatement.setString(i++, billDto.getProductName());
		preparedStatement.setDouble(i++, billDto.getValue());
		preparedStatement.setInt(i++, billDto.getAmount());
		preparedStatement.setDate(i++, billDto.getDate());
		preparedStatement.execute();
		preparedStatement.close();
		
	}

	
}
