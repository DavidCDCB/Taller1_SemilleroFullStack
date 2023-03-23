package Taller3.Banco.Cuentas;

import Taller3.Banco.Exepciones.RetirosExcedidos;

public abstract class Cuenta {
	protected double numero;
	protected double saldo;
	protected String propietario;

	public Cuenta(double numero, double saldo, String propietario) {
		this.numero = numero;
		this.saldo = saldo;
		this.propietario = propietario;
	}
	
	public abstract void depositar(double cantidad);
	public abstract void retirar(double cantidad) throws RetirosExcedidos;

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


}
