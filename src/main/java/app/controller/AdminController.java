package app.controller;

import java.util.Scanner;

import app.validators.PersonInputsValidator;
import app.dto.PersonDto;
import app.service.AdminService;
import app.service.VeterinaryService;

public class AdminController {
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static AdminService adminService = new VeterinaryService();
	private static final String MENU = "ingrese\n1.Para crear usuario\n2.Para cerrar Sesion";
	
	private void createUser() throws Exception {
		System.out.println("ingrese el nombre completo");
		int age = scanner.nextInt();
		personInputValidator.ageValidator(age);
		System.out.println("ingrese el nombre completo");
		String fullname = scanner.nextLine();
		personInputValidator.fullNameValidator(fullname);
		System.out.println("ingrese la cedula del usuario");
		int id = personInputValidator.idValidator(scanner.nextInt());
		System.out.println("ingrese el rol completo");
		int role_id = scanner.nextInt();
		personInputValidator.intValidator(role_id);
		System.out.println("ingrese nombre de usuario");
		String username = scanner.nextLine();
		personInputValidator.fullNameValidator(username);
		System.out.println("ingrese la contraseña");
		String password = scanner.nextLine();
		personInputValidator.fullNameValidator(password);
		PersonDto personDto = new PersonDto(age, role_id, fullname, username, password);
		System.out.println("se cumplieron todas las validaciones");
		adminService.createUser(personDto);
	}
	
	public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(MENU);
				String option = scanner.nextLine();
				runApp=menu(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	
	private boolean menu(String option) throws Exception{
		switch (option) {
		case "1":{
			createUser();
			return true;
		}
		case "2": {
			return false;
		}
		default :{
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
}
