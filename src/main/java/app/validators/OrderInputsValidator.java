package app.validators;

public class OrderInputsValidator extends InputsValidator{
	
	public int orderIdValidator(int orderId) throws Exception {
        return super.integerValidator(orderId, " id de orden");
    }
	public void PetValidator(String PetName) throws Exception {
        super.stringValidator(PetName, "nombre  de mascota");
    }
	public long idOwnerValidator(Long idOwner) throws Exception {
        return super.longValidator(idOwner, " identificacion del dueño");
    }
	public long personValidator(Long person) throws Exception {
		   return super.longValidator(person, " Identificacion del veterinario");
    }
	public void nameMedicationsValidator(String nameMedications) throws Exception {
        super.stringValidator(nameMedications, " Nombre de medicamentos");
    }
	

}
