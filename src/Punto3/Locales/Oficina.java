package Taller.Punto3.Locales;

public class Oficina extends Local {
	protected boolean esDelGobierno;
	private final static int VALOR_METRO_CUADRADO = 3500000;

	public Oficina(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public boolean isEsDelGobierno() {
		return esDelGobierno;
	}

	public void setEsDelGobierno(boolean esDelGobierno) {
		this.esDelGobierno = esDelGobierno;
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
}
