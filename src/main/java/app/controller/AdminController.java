package app.controller;

import java.util.Scanner;

import app.validators.PersonInputsValidator;
import app.dto.PersonDto;
import app.service.AdminService;

public class AdminController {
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static AdminService adminService = new AdminService();
	private static final String MENU = "ingrese\n1.Para crear usuario\n2.Para cerrar Sesion";
	
	private void createUser() throws Exception {
		
		 System.out.println("Ingrese la edad:");
		    int age = scanner.nextInt();
		    scanner.nextLine(); // Consumir el salto de línea

		    System.out.println("Ingrese el nombre completo:");
		    String fullname = scanner.nextLine();
		    personInputValidator.fullNameValidator(fullname);

		    System.out.println("Ingrese la cédula del usuario:");
		    long id = scanner.nextLong();
		    personInputValidator.idValidator(id);

		    System.out.println("Ingrese el ID del rol:");
		    int role_id = scanner.nextInt();
		    scanner.nextLine(); // Consumir el salto de línea
		    personInputValidator.intValidator(role_id);

		    System.out.println("Ingrese el nombre de usuario:");
		    String username = scanner.nextLine();
		    personInputValidator.fullNameValidator(username);

		    System.out.println("Ingrese la contraseña:");
		    String password = scanner.nextLine();
		    personInputValidator.fullNameValidator(password);

		    PersonDto personDto = new PersonDto(id, age, role_id, fullname, username, password);
		    System.out.println("Se cumplieron todas las validaciones");
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
