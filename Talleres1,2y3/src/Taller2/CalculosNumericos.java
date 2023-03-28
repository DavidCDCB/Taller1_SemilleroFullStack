package Taller2;

public class CalculosNumericos {

	public static Double CalcularRaiz(Double numero) throws ErrorAritmetico {
		if (numero < 0) {
			throw new ErrorAritmetico();
		}
		return (double) Math.sqrt(numero);
	}

	public static double pendiente(double x1, double x2, double y1, double y2) {
		return (y2 - y1) / (x2 - x1);
	}

	public static double[] puntoMedio(double x1, double y1, double x2, double y2) {
		double[] punto = new double[2];
		punto[0] = (x1 + x2) / 2;
		punto[1] = (y1 + y2) / 2;
		return punto;
	}

	public static double[] raicesCuadraticas(double a, double b, double c) throws ErrorAritmetico {
		double[] raices = new double[2];
		double discriminante = b * b - 4 * a * c;
		if(a == 0){
			throw new ErrorAritmetico();
		}
		if (discriminante >= 0) {
			raices[0] = (-b + Math.sqrt(discriminante)) / (2 * a);
			raices[1] = (-b - Math.sqrt(discriminante)) / (2 * a);
		} else {
			System.out.println("No hay raíces reales");
			raices[0] = Double.NaN;
			raices[1] = Double.NaN;
		}
		return raices;
	}

	public static String convertirBase(int numero, int base) throws ErrorAritmetico {
		String resultado = "";
		int resto;
		if(base == 0){
			throw new ErrorAritmetico();
		}
		while (numero > 0) {
			resto = numero % base;
			resultado = resto + resultado;
			numero = numero / base;
		}
		return resultado;
	}
}
