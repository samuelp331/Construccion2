package app.service;

import app.dto.OrderDto;

public interface IOrderService {
	public void createOrder(OrderDto orderdto) throws Exception;
	public void cancelOrder(int id) throws Exception;
}
