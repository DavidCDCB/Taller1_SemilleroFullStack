package com.cdcb.taller4.model;

import com.cdcb.taller4.exceptions.RetirosExcedidos;

public abstract class Cuenta {
	protected double numero;
	protected double saldo;
	protected String propietario;

	public static final String DDL = String.join("\n",
	"CREATE TABLE IF NOT EXISTS cuentas(",
			"id INTEGER PRIMARY KEY AUTOINCREMENT,",
			"numero REAL NOT NULL,",
			"saldo REAL NOT NULL,",
			"propietario TEXT NOT NULL,",
			"retiros INTEGER DEFAULT 0,",
			"depositos INTEGER DEFAULT 0",
		");"
	);

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

	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", saldo=" + saldo + ", propietario=" + propietario + "]";
	}


}
