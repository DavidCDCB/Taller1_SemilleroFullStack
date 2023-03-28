package com.cdcb.taller4.services;

import java.util.List;

import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.repositories.IRepository;

public class CuentaCorrienteService implements ICuentaService<CuentaCorriente> {
	private IRepository<CuentaCorriente> cuentaRepository;

	public CuentaCorrienteService(IRepository<CuentaCorriente> postRepository) {
		this.cuentaRepository = postRepository;
	}

	@Override
	public void createDDL() {
		this.cuentaRepository.createTable();
	}

	@Override
	public void saveCuenta(CuentaCorriente cuenta) {
		this.cuentaRepository.insert(cuenta);
		
	}

	@Override
	public List<CuentaCorriente> getCuentas() {
		List<CuentaCorriente> cuentas = this.cuentaRepository.selectAll();
		return cuentas;
	}

	@Override
	public CuentaCorriente getCuenta(int id) {
		try {
			return this.cuentaRepository.selectById(id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateCuenta(CuentaCorriente cuenta, int id) {
		try {
			this.cuentaRepository.update(cuenta, id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void removeCuenta(int id) {
		try {
			this.cuentaRepository.delete(id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
	}
}
