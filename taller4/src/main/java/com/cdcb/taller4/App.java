package com.cdcb.taller4;

import com.cdcb.taller4.cli.CliMenu;
import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.repositories.IRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaAhorrosRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaCorrienteRepository;
import com.cdcb.taller4.services.CuentaAhorrosService;
import com.cdcb.taller4.services.CuentaCorrienteService;
import com.cdcb.taller4.services.CuentaService;
import com.cdcb.taller4.services.ICuentaService;

public class App 
{
    public static void main( String[] args )
    {
        
        IRepository<CuentaAhorros> cuentaAhorrosRepository = new CuentaAhorrosRepository("cuentasDB.db");
        ICuentaService<CuentaAhorros> cuentaAhorrosService = new CuentaAhorrosService(cuentaAhorrosRepository);
        cuentaAhorrosService.createDDL();

        IRepository<CuentaCorriente> cuentaCorreienteRepository = new CuentaCorrienteRepository("cuentasDB.db");
        ICuentaService<CuentaCorriente> cuentaCorrienteService = new CuentaCorrienteService(cuentaCorreienteRepository);
    
        CuentaAhorros cuentaAhorros = new CuentaAhorros(1,2,"cdcb");
        cuentaAhorros.setCantidadRetiros(1);
        cuentaAhorrosService.saveCuenta(cuentaAhorros);

        System.out.println(cuentaAhorrosService.getCuenta(1).toString());
        cuentaAhorros.setPropietario("David");
        cuentaAhorrosService.updateCuenta(cuentaAhorros, 1);
        cuentaAhorrosService.removeCuenta(2);

        CliMenu cliMenu = new CliMenu(cuentaAhorrosService, cuentaCorrienteService);
    }
}
