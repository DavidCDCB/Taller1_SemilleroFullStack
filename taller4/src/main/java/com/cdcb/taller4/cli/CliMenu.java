package com.cdcb.taller4.cli;

import java.util.Scanner;

import com.cdcb.taller4.domain.Cuenta;
import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.repositories.IRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaAhorrosRepository;
import com.cdcb.taller4.services.CuentaAhorrosService;
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
		}else{
			CuentaCorriente cuenta = new CuentaCorriente(numero, saldo, propietario);
		}
	}

	public void menuBuscarCuenta(String tipo){
		int numero;
		System.out.println("Numero: ");
		numero = sc.nextInt();
		// Mostrar cuenta ...
		menuCambioCuenta(null);
	}


	public void menuCambioCuenta(Cuenta cuenta) {
		System.out.println("[1] Retirar cantidad");
		System.out.println("[2] Depositar cantidad");
		int input = sc.nextInt();
		switch (input) {
			case 1:
				
				break;
			case 2:
				
				break;
		
			default:
				break;
		}
	}
	
}
