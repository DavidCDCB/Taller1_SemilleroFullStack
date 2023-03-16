package Taller.Punto3.Apartamentos;

public class Apartaestudio extends Apartamento {
	private final static int VALOR_METRO_CUADRADO = 1500000;

	public Apartaestudio(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
		super.numeroHabitaciones = 1;
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
}
