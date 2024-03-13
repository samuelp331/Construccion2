package app.controller;

import java.util.Scanner;

import app.validators.PersonInputsValidator;
import app.dto.PersonDto;

public class VendorController {
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static VendorService vendorService = new VendorService();
	private static final String MENU = "ingrese\n1.Para generar venta\n2.Para cerrar Sesion";
	
	private void createSale() throws Exception {
		System.out.println("ingrese el nombre completo");
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
			createSale();
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
