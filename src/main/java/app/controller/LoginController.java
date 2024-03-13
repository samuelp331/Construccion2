package app.controller;

import java.util.Scanner;

import app.validators.PersonInputsValidator;
import app.service.VeterinaryService;
import app.dto.PersonDto;
import app.service.LoginService;

public class LoginController{
	
	private static Scanner scanner = new Scanner(System.in);
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static AdminController adminController = new AdminController();
	private static VendorController vendorController = new VendorController();
	
	private static LoginService loginService = new VeterinaryService();
	
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
		if (personDto.getRole().equals("Administrador")) {
			adminController.session();
		}
	}
	private void loginRouter(PersonDto personDto) {
		if (personDto.getRole().equals("Vendedor")) {
			vendorController.session();
		}
	}
	
}