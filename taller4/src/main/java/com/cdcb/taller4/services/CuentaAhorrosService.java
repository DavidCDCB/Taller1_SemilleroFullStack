package com.cdcb.taller4.services;

import java.util.List;

import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.exceptions.CuentaNoEncontrada;
import com.cdcb.taller4.repositories.IRepository;

public class CuentaAhorrosService implements ICuentaService<CuentaAhorros> {
	private IRepository<CuentaAhorros> cuentaRepository;

	public CuentaAhorrosService(IRepository<CuentaAhorros> postRepository) {
		this.cuentaRepository = postRepository;
	}

	@Override
	public void createDDL() {
		this.cuentaRepository.createTable();
	}

	@Override
	public void saveCuenta(CuentaAhorros cuenta) {
		this.cuentaRepository.insert(cuenta);
		
	}

	@Override
	public List<CuentaAhorros> getCuentas() {
		List<CuentaAhorros> cuentas = this.cuentaRepository.selectAll();
		return cuentas;
	}

	@Override
	public CuentaAhorros getCuenta(int id) {
		try {
			return this.cuentaRepository.selectById(id);
		} catch (CuentaNoEncontrada e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateCuenta(CuentaAhorros cuenta, int id) {
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

	@Override
	public void transferir(int idOrigen, int idDestino, double cantidad) {
		CuentaAhorros cuentaOrigen = this.getCuenta(idOrigen);
		CuentaAhorros cuentaDestino = this.getCuenta(idDestino);
		cuentaDestino.depositar(cantidad);
		cuentaOrigen.retirar(cantidad);
	}
}
