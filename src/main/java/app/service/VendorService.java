package app.service;

import app.dao.LoginDao;
import app.dao.OrderDao;
import app.dao.PersonDao;
import app.dao.SailDao;
import app.dto.BillDto;
import app.dto.PersonDto;
import app.dto.SessionDto;

public class VendorService implements IVendorService, ILoginService{
	private static long sessionId = 0L;

	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDao();
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRoleId(personDtoValidate.getRoleId());
		LoginDao loginDao = new LoginDao();
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("se inicia la sesion " + sessionId);
		
	}

	@Override
	public void logout() throws Exception {
		LoginDao loginDao = new LoginDao();
		loginDao.logout(sessionId);
		setSesionID(0);
		
	}

	@Override
	public void createSale(BillDto billDto) throws Exception {
		SailDao sailDao = new SailDao();
		sailDao.createSale(billDto);
		System.out.println("se ha creado la venta");		
	}

	@Override
	public String seeOrderById(int id) throws Exception {
		OrderDao orderDao = new OrderDao();
		return orderDao.seeOrder(id);
	}
}
