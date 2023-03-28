package Taller3.Formatos;

public abstract class FormatoAudio extends Formato {
	protected String artista;
	protected String compositor;
	protected String genero;

	public FormatoAudio(String duracion, String tamanio, String artista, String compositor, String genero) {
		super(duracion, tamanio);
		this.artista = artista;
		this.compositor = compositor;
		this.genero = genero;
	}
}
