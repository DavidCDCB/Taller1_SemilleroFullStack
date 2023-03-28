package com.cdcb.taller4;

import com.cdcb.taller4.cli.CliMenu;
import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.repositories.IRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaAhorrosRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaCorrienteRepository;
import com.cdcb.taller4.services.CuentaAhorrosService;
import com.cdcb.taller4.services.CuentaCorrienteService;
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

        CliMenu cliMenu = new CliMenu(cuentaAhorrosService, cuentaCorrienteService);
        cliMenu.menuPrincipal();
    }
}
