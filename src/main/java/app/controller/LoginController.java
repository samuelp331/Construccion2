package app.controller;

import java.util.Scanner;

import app.validators.PersonInputsValidator;
import app.dto.PersonDto;
import app.service.AdminService;
import app.service.ILoginService;

public class LoginController{
	
	private static Scanner scanner = new Scanner(System.in);
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static AdminController adminController = new AdminController();
	private static VendorController vendorController = new VendorController();
	private static VeterinarianController veterinarianController = new VeterinarianController();
	private static ILoginService loginService = new AdminService();
	
	
	public void login() throws Exception {
		System.out.println("ingrese su usuario");
		String username = scanner.nextLine();
		personInputValidator.fullNameValidator(username);
		System.out.println("ingrese su contraseña");
		String password = scanner.nextLine();
		personInputValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(username, password);
		loginService.login(personDto);
		loginRouter(personDto);
		loginService.logout();
	}
	private void loginRouter(PersonDto personDto) {
		
		if (personDto.getRoleId() == 1) {//hasta no asegurar el id del rol no se asigna
			adminController.session();
		}else if(personDto.getRoleId() == 2) {
			vendorController.session();
		}else if(personDto.getRoleId() == 3) {
			veterinarianController.session();
		}
	
	}
	
	
}