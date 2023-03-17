package Taller2;

public class Test {
	public static void main(String[] args) {
		try {
			Double resultadoRaiz = CalculosNumericos.CalcularRaiz((double)100);
			System.out.println(resultadoRaiz);
		} catch (ErrorAritmetico e) {
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}
	}
}
