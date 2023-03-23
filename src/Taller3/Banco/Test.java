package Taller3.Banco;

import Taller3.Banco.Cuentas.*;
import Taller3.Banco.Exepciones.RetirosExcedidos;

public class Test {
	
	public static void main(String[] args) {
		
		Cuenta cuenta = new CuentaCorriente(231243, 100000, "David");

		try {
			cuenta.retirar(200000);
		} catch (RetirosExcedidos e) {
			System.out.println(e.getMessage());
		}
		
	}
}
