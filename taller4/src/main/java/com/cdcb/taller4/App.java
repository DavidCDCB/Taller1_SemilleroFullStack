package com.cdcb.taller4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.cdcb.taller4.controllers.CuentaController;
import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.repositories.IRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaAhorrosRepository;


public class App 
{
    public static void main( String[] args )
    {
        IRepository<CuentaAhorros> cuentaAhorrosRepository = new CuentaAhorrosRepository("cuentasDB.db");
        cuentaAhorrosRepository.createTable();
        
        Server server = new Server(9090);
        server.setHandler(new DefaultHandler());

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(CuentaController.class, "/api/*");
        server.setHandler(context);

        try{
            server.start();
            server.join();
        }catch(Exception e){
            e.printStackTrace();
        }

    /* 

        IRepository<CuentaAhorros> cuentaAhorrosRepository = new CuentaAhorrosRepository("cuentasDB.db");
        ICuentaService<CuentaAhorros> cuentaAhorrosService = new CuentaAhorrosService(cuentaAhorrosRepository);
        cuentaAhorrosService.createDDL();

        IRepository<CuentaCorriente> cuentaCorreienteRepository = new CuentaCorrienteRepository("cuentasDB.db");
        ICuentaService<CuentaCorriente> cuentaCorrienteService = new CuentaCorrienteService(cuentaCorreienteRepository);
        CliMenu cliMenu = new CliMenu(cuentaAhorrosService, cuentaCorrienteService);
        cliMenu.menuPrincipal(); */
    }
}
