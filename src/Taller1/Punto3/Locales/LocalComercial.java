package Taller1.Punto3.Locales;

public class LocalComercial extends Local {
	protected String centroComercial;
	private final static int VALOR_METRO_CUADRADO = 3000000;

	public LocalComercial(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public String getCentroComercial() {
		return centroComercial;
	}

	public void setCentroComercial(String centroComercial) {
		this.centroComercial = centroComercial;
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
}
