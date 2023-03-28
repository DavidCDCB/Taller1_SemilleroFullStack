package Taller1.Punto3.Apartamentos;

public class ApartamentoFamiliar extends Apartamento {
	private final static int VALOR_METRO_CUADRADO = 2000000;

	public ApartamentoFamiliar(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}
	
	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
}
