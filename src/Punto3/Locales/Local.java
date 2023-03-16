package Taller.Punto3.Locales;

import Taller.Punto3.Vivienda;

public class Local extends Vivienda {
	protected String localizacion;

	public Local(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

}
