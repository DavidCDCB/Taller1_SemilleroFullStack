package com.cdcb.taller4.model;


import com.cdcb.taller4.exceptions.RetirosExcedidos;

public class CuentaCorriente extends Cuenta {

	private int cantidadDepositos = 0;
	private int cantidadRetiros = 0;

	public CuentaCorriente(double numero, double saldo, String propietario) {
		super(numero, saldo, propietario);
	}

	@Override
	public void depositar(double cantidad) {
		this.cantidadDepositos += (this.cantidadDepositos <= 2) ? cantidad+(cantidad*0.5) : cantidad;
		this.cantidadDepositos++;
	}

	@Override
	public void retirar(double cantidad) throws RetirosExcedidos {
		if(this.cantidadRetiros < 5){
			this.saldo -= cantidad;
		}else{
			throw new RetirosExcedidos("No se puede retirar mas de 5 veces");
		}
	}

	public int getCantidadDepositos() {
		return cantidadDepositos;
	}

	public void setCantidadDepositos(int cantidadDepositos) {
		this.cantidadDepositos = cantidadDepositos;
	}

	public int getCantidadRetiros() {
		return cantidadRetiros;
	}

	public void setCantidadRetiros(int cantidadRetiros) {
		this.cantidadRetiros = cantidadRetiros;
	}
	
	
}
