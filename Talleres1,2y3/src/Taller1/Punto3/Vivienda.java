package Taller1.Punto3;

public class Vivienda extends Inmueble {
	protected Integer numeroHabitaciones;
	protected Integer numerioBanios;

	public Vivienda(Integer identificador, Integer area, String direccion) {
		super(identificador, area, direccion);
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Integer getNumerioBanios() {
		return numerioBanios;
	}

	public void setNumerioBanios(Integer numerioBanios) {
		this.numerioBanios = numerioBanios;
	}
	
}
