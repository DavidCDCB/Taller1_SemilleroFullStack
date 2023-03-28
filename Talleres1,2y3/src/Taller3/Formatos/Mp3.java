package Taller3.Formatos;

public class Mp3 extends FormatoAudio {
	public Mp3(String duracion, String tamanio, String artista, String compositor, String genero) {
		super(duracion, tamanio, artista, compositor, genero);
	}

	@Override
	protected void reproducir() {
		// Reproducción particular del formato
	}
}
