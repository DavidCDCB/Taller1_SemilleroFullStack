package Taller1.Punto3;

public class Inmueble {
	protected Integer identificador;
	protected Integer area;
	protected String direccion;

	public Inmueble(Integer identificador, Integer area, String direccion) {
		this.identificador = identificador;
		this.area = area;
		this.direccion = direccion;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
