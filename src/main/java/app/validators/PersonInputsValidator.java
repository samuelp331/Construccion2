package app.validators;

public class PersonInputsValidator extends InputsValidator {
	
    public void fullNameValidator(String fullname) throws Exception {
        super.stringValidator(fullname, "Nombre de usuario incorrecto");
    }
    public long idValidator(long number) throws Exception {
        return super.longValidator(number, "es cedula valida");
    }
   public int ageValidator(int age) throws Exception{
	   return super.integerValidator(age, "Ingrese edad del usuario");
   }
   public void passwordValidator(String password) throws Exception{
	   super.stringValidator(password, "Es clave valida");
   }
   public int intValidator(int number) throws Exception{
	   return super.integerValidator(number, "Es id valida");
   }
}


 