package app.validators;

public abstract class InputsValidator {
    public void stringValidator(String string, String element) throws Exception {
        if (string == null || string.equals("")) {
            throw new Exception(element + " no es un valor valido");
        }
    }

    public int integerValidator(int number, String element) throws Exception {
        //stringValidator(number, element);
        try {
            return number ;/*Integer.parseInt(number);*/
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public long longValidator(long number, String element) throws Exception {
        longValidator(number, element);
        try {
            return number; //Long.parseLong(number);
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public double doubleValidator(long number, String element) throws Exception {
        longValidator(number, element);
        try {
            return number;//Double.parseDouble(number);
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
}
