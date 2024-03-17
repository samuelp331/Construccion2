package app.service;

import app.dao.ClinicHistoryDao;
import app.dao.LoginDao;
import app.dao.OrderDao;
import app.dao.PersonDao;
import app.dao.PetDao;
import app.dto.ClinicHistoryDto;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.dto.SessionDto;

public class VeterinarianService implements IClinicHistoryService, IPetService, IOrderService, ILoginService {
	
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
	public int createOrder(OrderDto orderdto) throws Exception {
		OrderDao orderDao = new OrderDao();
		int orderId = orderDao.createOrder(orderdto);
		System.out.println("se ha creado la orden");
		return orderId;
	}

	@Override
	public void cancelOrder(int id) throws Exception {
		OrderDao orderDao = new OrderDao();
		orderDao.cancelOrder(id);
		System.out.println("se ha cancelado la orden #" + id);
	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		PetDao petDao = new PetDao();
		PersonDao personDao = new PersonDao();
		boolean ownerExist = personDao.findUserExistById(petDto.getOwnerId()); 
		if(!ownerExist) {
			throw new Exception("el dueño no existe");
		}
		petDao.createPet(petDto);
		System.out.println("se ha creado la mascota");
	}


	@Override
	public void CreateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		ClinicHistoryDao clinicHistoryDao = new ClinicHistoryDao();
		clinicHistoryDao.CreateClinicHistory(clinichistorydto);
		System.out.println("se ha creao la historia clinica de la mascota");
	}

	@Override
	public void UpdateClinicHistory(ClinicHistoryDto clinichistorydto) throws Exception {
		ClinicHistoryDao clinicHistoryDao = new ClinicHistoryDao();
		boolean existClinicHistory = clinicHistoryDao.existClinicHistory(clinichistorydto.getId());
		if(existClinicHistory) {
			clinicHistoryDao.UpdateClinicHistory(clinichistorydto);
			System.out.println("se ha creao la historia clinica de la mascota");
		}else {
			throw new Exception(" la historia clinica no existe");
		}
		
	}

	@Override
	public String getHistoryClinicDetails(int id) throws Exception {
		ClinicHistoryDao clinicHistoryDao = new ClinicHistoryDao();
		return clinicHistoryDao.getHistoryClinicDetails(id);
	}

	@Override
	public String seeOrder(int id) throws Exception {
		OrderDao orderDao = new OrderDao();
		return orderDao.seeOrder(id);
	}

}
