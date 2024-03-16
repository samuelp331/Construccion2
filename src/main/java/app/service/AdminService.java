package app.service;

import java.util.Arrays;
import java.util.List;

import app.dto.PersonDto;
import app.dto.SessionDto;
import app.dao.PersonDao;
import app.dao.LoginDao;
import app.dao.ILoginDao;
import app.dao.PersonDaoImp;

public class AdminService implements IAdminService,ILoginService{
	List<Integer> roles = Arrays.asList(01,02,03,04);
	private static long sessionId = 0L;

	@Override
	public void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRoleId())) {
			throw new Exception("el rol no es valido");
		}
		PersonDao personDao = new PersonDaoImp();
		if (personDao.findUserExist(personDto)) {
			throw new Exception("ya existe un usuario con esa cedula");
		}
		if (personDao.existUserByUserName(personDto)) {
			throw new Exception("ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("se ha creado el usuario");
	}


	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDaoImp();
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRoleId(personDtoValidate.getRoleId());
		ILoginDao loginDao = new LoginDao();
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSesionID(sesionDto.getId());
		System.out.println("se inicia la sesion " + sessionId);
	}

	@Override
	public void logout() throws Exception {
		ILoginDao loginDao = new LoginDao();
		loginDao.logout(sessionId);
		setSesionID(0);
	}
}
