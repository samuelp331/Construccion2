package app.validators;

public class PersonInputsValidator extends InputsValidator {
	
    public void fullNameValidator(String fullname) throws Exception {
        super.stringValidator(fullname, "Nombre de usuario incorrecto");
    }
    public long idValidator(String number) throws Exception {
        return super.longValidator(number, "id de usuario");
    }
   public int ageValidator(String age) throws Exception{
	   return super.integerValidator(age, "Ingrese edad del usuario");
   }
   public void passwordValidator(String password) throws Exception{
	   super.stringValidator(password, "Es clave valida");
   }
}


 