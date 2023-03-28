package com.cdcb.taller4.domain;

public class CuentaAhorros extends Cuenta {

	private int cantidadRetiros = 0;

	public CuentaAhorros(double numero, double saldo, String propietario) {
		super(numero, saldo, propietario);
	}

	@Override
	public void depositar(double cantidad) {
		this.saldo += cantidad;
	}

	@Override
	public void retirar(double cantidad) {
		this.saldo -= ((this.cantidadRetiros < 3)) ? this.saldo : this.saldo-cantidad+(cantidad*0.1);
		this.cantidadRetiros++;
	}

	public int getCantidadRetiros() {
		return cantidadRetiros;
	}

	public void setCantidadRetiros(int cantidadRetiros) {
		this.cantidadRetiros = cantidadRetiros;
	}

	
	

}
