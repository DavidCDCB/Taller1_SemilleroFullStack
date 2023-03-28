package com.cdcb.taller4.services;

import java.util.List;

public interface ICuentaService<T> {
	public void createDDL();
	public void saveCuenta(T cuenta);
	public List<T> getCuentas();
	public T getCuenta(int id);
	public void updateCuenta(T cuenta, int id);
	public void removeCuenta(int id);
	public void transferir(int idOrigen, int idDestino, double cantidad);
}
