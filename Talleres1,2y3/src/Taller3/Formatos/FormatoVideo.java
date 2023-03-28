package Taller3.Formatos;

public abstract class FormatoVideo extends Formato {
	protected String creador;
	protected String tipo;

	public FormatoVideo(String duracion, String tamanio, String creador, String tipo) {
		super(duracion, tamanio);
		this.creador = creador;
		this.tipo = tipo;
	}
}
