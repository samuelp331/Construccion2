package app.service;

import java.util.List;

import app.dao.PersonDao;
import app.dao.LoginDao;
import app.dao.PersonDaoImp;
import app.dto.BillDto;
import app.dto.PersonDto;

public class VendorService implements IVendorService, ILoginService{
	private static long sessionId = 0L;

	@Override
	public void setSesionID(long sesionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSale(BillDto billDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBill(BillDto billDto) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
