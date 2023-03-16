package Taller.Punto2;

public class CuentaCorriente extends CuentaAhorros {
	private Float sobreGiro = (float)0;

	public CuentaCorriente(Float saldo, Float tasaAnual) {
		super(saldo, tasaAnual);
	}

	public void consignar(Float cantidad){
		if(this.sobreGiro > 0){
			this.sobreGiro -= cantidad;
			super.consignarCantidad(cantidad+this.sobreGiro);
		}else{
			super.consignarCantidad(cantidad);
		}
	}

	public void retirar(Float cantidad){
		if(cantidad > this.getSaldo()){
			this.sobreGiro = cantidad - this.getSaldo();
		}
		super.retirarCantidad(cantidad);
	}

	public void extractoMensual(){
		super.extractoMensual();
	}

	public void imprimir(){
		System.out.println(this.sobreGiro);
		super.toString();
	}
}
