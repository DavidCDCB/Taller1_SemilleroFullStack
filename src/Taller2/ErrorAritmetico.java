package Taller2;

public class ErrorAritmetico extends ArithmeticException {
	
	@Override
	public String getMessage() {
		System.out.println("¡Error Aritmetico!");
		return super.getMessage();
	}
}
