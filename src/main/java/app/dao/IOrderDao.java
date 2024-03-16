package app.dao;

import app.dto.OrderDto;

public interface IOrderDao {
	public void createOrder(OrderDto orderdto) throws Exception;
	public boolean cancelOrder(int id) throws Exception;
}
