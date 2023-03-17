package Taller1.Punto3.Casas;

import Taller1.Punto3.Vivienda;

public class Casa extends Vivienda {
	protected Integer cantidadPisos;

	public Casa(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public Integer getCantidadPisos() {
		return cantidadPisos;
	}

	public void setCantidadPisos(Integer cantidadPisos) {
		this.cantidadPisos = cantidadPisos;
	}
}
