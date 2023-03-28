package Taller1.Punto2;

public class CuentaAhorros extends CuentaBancaria {
	private boolean activada;
	private static final int MONTO_MINIMO = 10000;
	private static final int ADICIONAL_COMISION = 1000;

	public CuentaAhorros(Float saldo, Float tasaAnual) {
		super(saldo, tasaAnual);
		this.verificarActivacion();
	}

	private void verificarActivacion(){
		this.activada = this.getSaldo() >= MONTO_MINIMO;
	}
	
	public void consignar(Float cantidad){
		super.consignarCantidad(cantidad);
		this.verificarActivacion();
	}

	public void retirar(Float cantidad){
		super.retirarCantidad(cantidad);
		this.verificarActivacion();
	}

	public void extractoMensual(){
		if(this.getNumeroRetiros() > 4){
			super.setComisionMensual((float)ADICIONAL_COMISION);	
		}
		super.extractoMensual();
	}

	public void imprimir(){
		System.out.println(this.activada);
		super.imprimir();
	}

}
