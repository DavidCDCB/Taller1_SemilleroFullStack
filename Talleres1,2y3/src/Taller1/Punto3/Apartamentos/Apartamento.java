package Taller1.Punto3.Apartamentos;

import Taller1.Punto3.Vivienda;

public class Apartamento extends Vivienda {
	protected Float valorAdministración;

	public Apartamento(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public Float getValorAdministración() {
		return valorAdministración;
	}

	public void setValorAdministración(Float valorAdministración) {
		this.valorAdministración = valorAdministración;
	}
	
	
}
