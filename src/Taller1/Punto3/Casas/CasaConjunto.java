package Taller1.Punto3.Casas;

public class CasaConjunto extends Casa {
	protected String ubicacion;
	protected Float valorAdministracion;
	protected boolean tieneAreasComunes;
	private final static int VALOR_METRO_CUADRADO = 2500000;

	public CasaConjunto(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Float getValorAdministracion() {
		return valorAdministracion;
	}

	public void setValorAdministracion(Float valorAdministracion) {
		this.valorAdministracion = valorAdministracion;
	}

	public boolean isTieneAreasComunes() {
		return tieneAreasComunes;
	}

	public void setTieneAreasComunes(boolean tieneAreasComunes) {
		this.tieneAreasComunes = tieneAreasComunes;
	}

	public static int getValorMetroCuadrado() {
		return VALOR_METRO_CUADRADO;
	}
	
	
}
