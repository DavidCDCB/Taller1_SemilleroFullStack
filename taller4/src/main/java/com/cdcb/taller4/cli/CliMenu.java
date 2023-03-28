package com.cdcb.taller4.cli;

import java.util.Scanner;

import com.cdcb.taller4.domain.Cuenta;
import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.exceptions.RetirosExcedidos;
import com.cdcb.taller4.services.ICuentaService; 

public class CliMenu {
	private Scanner sc = new Scanner(System.in);
	private ICuentaService<CuentaAhorros> cuentaAhorrosService;
	private ICuentaService<CuentaCorriente> cuentaCorrienteService;

	public CliMenu(ICuentaService<CuentaAhorros> cuentaAhorrosService,
			ICuentaService<CuentaCorriente> cuentaCorrienteService) {
		this.cuentaAhorrosService = cuentaAhorrosService;
		this.cuentaCorrienteService = cuentaCorrienteService;
	}

	public void menuPrincipal() {
		System.out.println("[1] Gestión de cuentas de ahorros");
		System.out.println("[2] Gestión de cuentas de corriente");
		int input = sc.nextInt();
		switch (input) {
			case 1:
				this.menuCuentas("ahorros");
				break;
			case 2:
				this.menuCuentas("corriente");
				break;
		
			default:
				break;
		}
	}
	

	public void menuCuentas(String tipo) {
		System.out.println("[1] Crear Cuenta");
		System.out.println("[2] Buscar cuenta");
		int input = sc.nextInt();
		switch (input) {
			case 1:
				menuCrearCuenta(tipo);
				break;
			case 2:
				menuBuscarCuenta(tipo);
				break;
		
			default:
				break;
		}
	}

	public void menuCrearCuenta(String tipo){
		int numero;
		int saldo;
		String propietario;

		System.out.println("Numero: ");
		numero = sc.nextInt();
		System.out.println("Saldo: ");
		saldo = sc.nextInt();
		System.out.println("Propietario: ");
		propietario = sc.nextLine();
		if(tipo.equals("ahorros")){
			CuentaAhorros cuenta = new CuentaAhorros(numero, saldo, propietario);
			cuentaAhorrosService.saveCuenta(cuenta);
		}else{
			CuentaCorriente cuenta = new CuentaCorriente(numero, saldo, propietario);
			cuentaCorrienteService.saveCuenta(cuenta);
		}
	}

	public void menuBuscarCuenta(String tipo){
		int numero;
		Cuenta encontrada = null;
		System.out.println("Numero: ");
		numero = sc.nextInt();
		if(tipo.equals("ahorros")){
			encontrada = cuentaAhorrosService.getCuenta(numero);
		}else{
			encontrada = cuentaCorrienteService.getCuenta(numero);
		}
		if(encontrada != null){
			System.out.println(encontrada);
			menuCambioCuenta(encontrada, tipo);
		}
	}

	public void menuCambioCuenta(Cuenta cuenta, String tipo) {
		double cantidad;
		System.out.println("[1] Retirar cantidad");
		System.out.println("[2] Depositar cantidad");
		int input = sc.nextInt();
		System.out.println("Cantidad: ");
		switch (input) {
			case 1:
				cantidad = sc.nextDouble();
				try {
					cuenta.retirar(cantidad);
				} catch (RetirosExcedidos e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				cantidad = sc.nextDouble();
				cuenta.depositar(cantidad);
				break;
			default:
				break;
		}
		if(tipo.equals("ahorros")){
			cuentaAhorrosService.updateCuenta((CuentaAhorros)cuenta, (int)cuenta.getNumero());
		}else{
			cuentaCorrienteService.updateCuenta((CuentaCorriente)cuenta, (int)cuenta.getNumero());
		}
	}
	
}
