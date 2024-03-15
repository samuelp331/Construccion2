package app.service;

import app.dto.BillDto;
import app.dto.SaleDto;

public interface IVendorService {
	public void createSale(SaleDto saleDto)throws Exception;
	public void createBill(BillDto billDto)throws Exception;
}
