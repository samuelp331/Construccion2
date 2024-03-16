package app.service;

import java.util.Arrays;
import java.util.List;

import app.dao.PersonDao;
import app.dao.LoginDao;
import app.dao.PersonDaoImp;
import app.dto.BillDto;
import app.dto.PersonDto;
import app.dto.SaleDto;

public class VendorService implements IVendorService, LoginService{
	private static long sessionId = 0L;

	@Override
	public void createSale(SaleDto saleDto) throws Exception {
	}
	
	@Override
	public void createBill(BillDto billDto) throws Exception {
	}

	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionI pulld;
	}

	@Override
	public void logout() throws Exception {
		LoginDao loginDao = new LoginDaoImp();
		loginDao.logout(sessionId);
		setSesionID(0);
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
