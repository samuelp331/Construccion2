package app.validators;

public class BillInputsValidator extends InputsValidator {
	

	public void PetValidator(String PetName) throws Exception {
        super.stringValidator(PetName, "nombre  de mascota");
    }
	public void OwnerValidator(String OwnerName) throws Exception {
        super.stringValidator(OwnerName, " dueño de mascota");
    }
	public void productNameValidator(String productName) throws Exception {
        super.stringValidator(productName, "Nombre del producto");
    }
	public double priceValidator(Long price) throws Exception {
        return super.doubleValidator(price, "precio");
    }
	
}
