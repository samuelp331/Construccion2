package app.service;

import app.dto.OrderDto;

public interface IOrderService {
	public int createOrder(OrderDto orderdto) throws Exception;
	public void cancelOrder(int id) throws Exception;
	public String seeOrder(int id) throws Exception;
}
