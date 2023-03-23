package Taller3.Formatos;

public class Mp4 extends FormatoVideo {
	public Mp4(String duracion, String tamanio, String creador, String tipo) {
		super(duracion, tamanio, creador, tipo);
	}

	@Override
	protected void reproducir() {
		// Reproducción particular del formato
	}
}
