package app.service;


import app.dto.BillDto;

public interface IVendorService {
	public void createSale(BillDto billDto)throws Exception;
	public void createBill(BillDto billDto)throws Exception;
}
