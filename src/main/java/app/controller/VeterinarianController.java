package app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.dto.ClinicHistoryDto;
import app.dto.OrderDto;
import app.dto.PetDto;
import app.service.VeterinarianService;
import app.validators.ClinicHistoryInputsValidator;
import app.validators.OrderInputsValidator;
import app.validators.PersonInputsValidator;
import app.validators.PetInputsValidator;

public class VeterinarianController {
	
	private static ClinicHistoryInputsValidator clinicHistoryInputsValidator = new ClinicHistoryInputsValidator();
	private static OrderInputsValidator orderInputsValidator = new OrderInputsValidator();
	private static PetInputsValidator petInputsValidator = new PetInputsValidator();
	private static Scanner scanner = new Scanner(System.in);
	private static VeterinarianService veterinarianService = new VeterinarianService();
	private static final String MENU = "ingrese\n1.Para registrar una mascota\n2.Para registrar una historia clinica\n3.Para consultar una historia clinica\n4.Para anular una orden\n5.Para cerrar sesion";
	

	private boolean validateProcedure(String optionProcedure) throws Exception {
		if(optionProcedure == "vacunacion" || optionProcedure  == "vaccination") {
			return true;
		}
		return false;
	}
	private void generateHistory() throws Exception {
		
		System.out.println("Ingrese el id del veterinario");
		long veterinarianId = scanner.nextInt();
		clinicHistoryInputsValidator.veterinarianValidator(veterinarianId);

		System.out.println("Ingrese 1. para recetar medicamentos, 2. para no recetar medicamentos");
		int optionMedication = scanner.nextInt();
		clinicHistoryInputsValidator.validatePrescribeMedications(optionMedication);
		scanner.nextLine(); 
		
		String medications = null;
		String dosis = null;
		Integer orderId = null;

		if(optionMedication == 1) {
			System.out.println("Ingrese el nombre del medicamento/s");
			medications = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(medications);

			System.out.println("Ingrese la dosis");
			dosis = scanner.nextLine();
			clinicHistoryInputsValidator.medicinesValidator(dosis);

			System.out.println("Ingrese el id de la mascota");
			int petId = scanner.nextInt();
			scanner.nextLine(); 
			orderInputsValidator.PetValidator(petId);

			System.out.println("Ingrese el id del dueño");
			Long ownerId = scanner.nextLong();
			scanner.nextLine(); 
			orderInputsValidator.idOwnerValidator(ownerId);

			String dosisMedications = "medications: " + medications + " dosis: " + dosis;

		    OrderDto orderDto = new OrderDto(petId, veterinarianId, ownerId, dosisMedications, false);
		    orderId = veterinarianService.createOrder(orderDto);
		}

		System.out.println("Ingrese el tipo de procedimiento");
		String optionProcedure = scanner.nextLine();
		clinicHistoryInputsValidator.proceduresValidator(optionProcedure);

		String vaccinationHistory = null;
		boolean procedure = this.validateProcedure(optionProcedure);
		if(procedure) {
		    System.out.println("Ingrese la historia de vacunacion");
		    vaccinationHistory = scanner.nextLine();
		    clinicHistoryInputsValidator.vaccionationHistoryValidator(vaccinationHistory);
		}

		System.out.println("Ingrese la razón de consulta");
		String reason = scanner.nextLine();
		clinicHistoryInputsValidator.reasonForConsultationValidator(reason);

		System.out.println("Ingrese síntomas");
		String symptoms = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(symptoms);

		System.out.println("Ingrese diagnóstico");
		String diagnostic = scanner.nextLine();
		clinicHistoryInputsValidator.symptomsValidator(diagnostic);

		System.out.println("Medicamentos a los que presenta alergia");
		String allergies = scanner.nextLine();
		clinicHistoryInputsValidator.allergiesValidator(allergies);

		System.out.println("Detalles del procedimiento");
		String detailsProcedures = scanner.nextLine();
		clinicHistoryInputsValidator.detailsProceduresValidator(detailsProcedures);

		ClinicHistoryDto clinicHistoryDto = new ClinicHistoryDto(veterinarianId,reason, symptoms,optionProcedure,diagnostic,medications, dosis,orderId, vaccinationHistory, detailsProcedures,0);
		veterinarianService.CreateClinicHistory(clinicHistoryDto);
	
	}
	private void searchHistory() throws Exception {
		System.out.println("Ingrese 1.para recetar medicamentos, 2.no recetar medicamentos");
		int optionMedication = scanner.nextInt();
		clinicHistoryInputsValidator.validatePrescribeMedications(optionMedication);
		
		
	}
	private void searchOrder() throws Exception {
		
		System.out.println("Ingrese el id de la orden");
		int orderId = scanner.nextInt();
		orderInputsValidator.orderIdValidator(orderId);		
		System.out.println(veterinarianService.seeOrder(orderId));
	}
	private void createPet() throws Exception {
		System.out.println("Ingrese el nombre de la mascota");
		String petName = scanner.nextLine();
		petInputsValidator.nameValidator(petName);

		System.out.println("Ingrese la edad de la mascota");
		int age = scanner.nextInt();
		petInputsValidator.ageValidator(age);

		System.out.println("Ingrese la especie de la mascota");
		scanner.nextLine(); 
		String species = scanner.nextLine();
		petInputsValidator.speciesValidator(species);

		System.out.println("Ingrese la raza de la mascota");
		String breed = scanner.nextLine();
		petInputsValidator.speciesValidator(breed);

		System.out.println("Ingrese las características de la mascota");
		String characteristics = scanner.nextLine();
		petInputsValidator.characteristicsValidator(characteristics);

		System.out.println("Ingrese el peso de la mascota");
		int weight = scanner.nextInt();
		petInputsValidator.weightValidator(weight);

		System.out.println("Ingrese el ID del dueño");
		Long ownerId = scanner.nextLong();
		petInputsValidator.idOwnerValidator(ownerId);

		PetDto petDto = new PetDto(petName,age,species,breed,characteristics,weight,ownerId);
		veterinarianService.createPet(petDto);
	}
	private void deleteOrder() throws Exception {
		System.out.println("ingrese el id de la orden");
		int petId = scanner.nextInt();
		orderInputsValidator.orderIdValidator(petId);		
		veterinarianService.cancelOrder(petId);
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
				searchOrder();
				return true;
			}
			case "5": {
				deleteOrder();
				return true;
			}
			case "6": {
				return false;
			}
			default :{
				System.out.println("ingrese una opcion valida");
				return true;
			}
		}
	}
}
