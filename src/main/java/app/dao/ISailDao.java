package app.dao;

import app.dto.BillDto;

public interface ISailDao {
	public void createSale(BillDto billDto)throws Exception;
}
