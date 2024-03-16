package app.controller;

import java.util.Scanner;

import app.service.VeterinarianService;
import app.validators.PersonInputsValidator;

public class VeterinarianController {
	
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static VeterinarianService veterinaianService = new VeterinarianService();
	private static final String MENU = "ingrese\n1.Para registrar una mascota\n2.Para registrar una historia clinica\n3.Para consultar una historia clinica\n4.Para generar una orden\n5.Para anular una orden\n6.Para cerrar sesion";
	
	
	private void generateOrder() throws Exception {
		System.out.println("ingrese el nombre de la mascota");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
	}
	private void generateHistory() throws Exception {
		System.out.println("ingrese el nombre de la mascota");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
	}
	private void searchHistory() throws Exception {
		System.out.println("ingrese el id de la historia");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
	}
	private void searchOrder() throws Exception {
		System.out.println("ingrese el id de la orden");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
	}
	private void createPet() throws Exception {
		System.out.println("ingrese el nombre de la mascota");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
	}
	private void deleteOrder() throws Exception {
		System.out.println("ingrese el id de la orden");
		String name = scanner.nextLine();
		personInputValidator.fullNameValidator(name);
		
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
				createPet();
				return true;
			}
			case "2": {
				generateHistory();
				return true;
			}
			case "3": {
				searchHistory();
				return true;
			}
			case "4": {
				generateOrder();
				return true;
			}
			case "5": {
				searchOrder();
				return true;
			}
			case "6": {
				deleteOrder();
				return true;
			}
			case "7": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}
}
