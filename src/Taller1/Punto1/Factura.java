package Taller1.Punto1;

public class Factura extends Precio {

	public Factura(String emisor, String cliente) {
		super(emisor, cliente);
	}
	
	private void imprimirFactura(){
		System.out.println(super.toString());
	}
}
