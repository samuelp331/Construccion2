package app.controller;

import java.util.Scanner;

import app.validators.BillInputsValidator;
import app.validators.OrderInputsValidator;
import app.validators.PersonInputsValidator;
import app.validators.PetInputsValidator;
import app.dto.BillDto;
import app.dto.PersonDto;
import app.service.VendorService;

public class VendorController {
	
	private static PersonInputsValidator personInputValidator = new PersonInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static OrderInputsValidator orderValidator = new OrderInputsValidator();
	private static BillInputsValidator billValidator = new BillInputsValidator();
	private static VendorService vendorService = new VendorService();
	private static final String MENU = "ingrese\n1.Para generar venta\\n2.Buscar orden\n3.Para cerrar Sesion";
	
	private void createSale() throws Exception {
		System.out.println("Ingrese el id de la mascota:");
		int petId = scanner.nextInt();
		scanner.nextLine(); 

		System.out.println("Ingrese el id del dueño:");
		Long ownerId = scanner.nextLong();
		scanner.nextLine(); 

		System.out.println("Ingrese el id de la orden:");
		int orderId = scanner.nextInt();
		scanner.nextLine(); 

		System.out.println("Ingrese el nombre del producto:");
		String productName = scanner.nextLine();
		billValidator.productNameValidator(productName);

		System.out.println("Ingrese el valor del producto:");
		Double value = scanner.nextDouble();
		scanner.nextLine(); 

		System.out.println("Ingrese la cantidad del producto:");
		int mount = scanner.nextInt();
		scanner.nextLine();
		billValidator.amountValidator(mount);	
		
		BillDto billDto = new BillDto(petId,ownerId,orderId,productName,value,mount);
		vendorService.createSale(billDto);
	}
	
	private void searchOrder() throws Exception {
		System.out.println("Ingrese el id de la orden");
		int orderId = scanner.nextInt();
		orderValidator.orderIdValidator(orderId);	
		scanner.nextLine();
		System.out.println(vendorService.seeOrderById(orderId));
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
				searchOrder();
				return true;
			}
			case "3": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}
}
