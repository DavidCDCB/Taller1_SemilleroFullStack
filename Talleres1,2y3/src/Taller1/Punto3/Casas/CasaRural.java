package Taller1.Punto3.Casas;

public class CasaRural extends Casa {
	protected Integer distancia;
	protected Integer altutud;
	private final static int VALOR_METRO_CUADRADO = 1500000;

	public CasaRural(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Integer getAltutud() {
		return altutud;
	}

	public void setAltutud(Integer altutud) {
		this.altutud = altutud;
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
	
}
