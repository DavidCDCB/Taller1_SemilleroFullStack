package Taller1.Punto1;

public class Precio {
	protected String emisor;
	protected String cliente;

	public Precio(String emisor, String cliente) {
		this.emisor = emisor;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Precio [emisor=" + emisor + ", cliente=" + cliente + "]";
	}

}
