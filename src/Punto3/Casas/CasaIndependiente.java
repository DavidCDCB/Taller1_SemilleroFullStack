package Taller.Punto3.Casas;

public class CasaIndependiente extends Casa {
	private final static int VALOR_METRO_CUADRADO = 3000000;

	public CasaIndependiente(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
	
}
