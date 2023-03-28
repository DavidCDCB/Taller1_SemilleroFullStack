package Taller3.Formatos;

public abstract class Formato {
	protected String duracion;
	protected String tamanio;

	public Formato(String duracion, String tamanio) {
		this.duracion = duracion;
		this.tamanio = tamanio;
	}

	protected abstract void reproducir();
}
