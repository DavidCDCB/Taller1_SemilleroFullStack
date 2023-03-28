package com.cdcb.taller4;

import com.cdcb.taller4.model.CuentaAhorros;
import com.cdcb.taller4.model.CuentaCorriente;
import com.cdcb.taller4.repositories.CuentaAhorrosRepository;
import com.cdcb.taller4.repositories.CuentaCorrienteRepository;
import com.cdcb.taller4.repositories.IRepository;
import com.cdcb.taller4.services.CuentaService;

public class App 
{
    public static void main( String[] args )
    {
        
        IRepository<CuentaAhorros> cuentaAhorrosRepository = new CuentaAhorrosRepository("cuentasDB.db");
        CuentaService<CuentaAhorros> cuentaAhorrosService = new CuentaService<>(cuentaAhorrosRepository);
        cuentaAhorrosService.createDDL();

        IRepository<CuentaCorriente> cuentaCorreienteRepository = new CuentaCorrienteRepository("cuentasDB.db");
        CuentaService<CuentaCorriente> cuentaCorrienteService = new CuentaService<>(cuentaCorreienteRepository);
    
        CuentaAhorros cuentaAhorros = new CuentaAhorros(1,2,"cdcb");
        cuentaAhorros.setCantidadRetiros(1);
        cuentaAhorrosService.saveCuenta(cuentaAhorros);

        System.out.println(cuentaAhorrosService.getCuenta(1).toString());
        cuentaAhorros.setPropietario("David");
        cuentaAhorrosService.updateCuenta(cuentaAhorros, 1);
        cuentaAhorrosService.removeCuenta(2);
    }
}
