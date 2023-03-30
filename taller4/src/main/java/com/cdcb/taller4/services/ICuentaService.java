package com.cdcb.taller4.services;

import java.util.List;

public interface ICuentaService<T> {
	public void createDDL();
	public void saveCuenta(T cuenta);
	public List<T> getCuentas();
	public T getCuenta(int id);
	public boolean updateCuenta(T cuenta, int id);
	public boolean removeCuenta(int id);
	public void transferir(int idOrigen, int idDestino, double cantidad);
}
