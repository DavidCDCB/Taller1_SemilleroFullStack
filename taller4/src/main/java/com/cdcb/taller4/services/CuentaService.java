package com.cdcb.taller4.services;

import java.util.List;

import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.repositories.IRepository;

public class CuentaService<T> {
	private IRepository<T> cuentaRepository;

	public CuentaService(IRepository<T> cuentaRepository) {
		this.cuentaRepository = cuentaRepository;
	}

	public void createDDL() {
		this.cuentaRepository.createTable();
	}

	public void saveCuenta(T cuenta) {
		this.cuentaRepository.insert(cuenta);
	}
	
	public List<T> getCuentas() {
		List<T> cuentas = this.cuentaRepository.selectAll();
		return cuentas;
	}

	public T getCuenta(int id) {
		try {
			return this.cuentaRepository.selectById(id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void updateCuenta(T cuenta, int id) {
		try {
			this.cuentaRepository.update(cuenta, id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeCuenta(int id) {
		try {
			this.cuentaRepository.delete(id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
	}
}
