package com.cdcb.taller4.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdcb.taller4.domain.CuentaAhorros;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 

import com.cdcb.taller4.domain.CuentaAhorros;
import com.cdcb.taller4.domain.CuentaCorriente;
import com.cdcb.taller4.repositories.Cuenta.CuentaAhorrosRepository;
import com.cdcb.taller4.repositories.Cuenta.CuentaCorrienteRepository;
import com.cdcb.taller4.services.CuentaAhorrosService;
import com.cdcb.taller4.services.CuentaCorrienteService;
import com.cdcb.taller4.services.ICuentaService;


public class CuentaController extends HttpServlet {
	private ICuentaService<CuentaAhorros> cuentaAhorrosService 
		= new CuentaAhorrosService(new CuentaAhorrosRepository("cuentasDB.db"));

    private ICuentaService<CuentaCorriente> cuentaCorrienteService 
		= new CuentaCorrienteService(new CuentaCorrienteRepository("cuentasDB.db"));
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

        //cuentaAhorrosService.createDDL();

		switch (req.getPathInfo()) {
			case "/cuentaAhorro/buscar":
				int numero = Integer.parseInt(req.getParameter("numero"));
				CuentaAhorros cuenta = cuentaAhorrosService.getCuenta(numero);
				resp.getWriter().write(this.objectToString(cuenta));
				break;

			case "/cuentaAhorro":
				List<CuentaAhorros> cuentas = new ArrayList<CuentaAhorros>();
				CuentaAhorros cuentaAhorros = new CuentaAhorros(1, 100, "David");
				cuentas.add(cuentaAhorros);
				resp.getWriter().write(this.objectToString(cuentas));
				break;

			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getContentType() != "application/json"){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		switch (req.getPathInfo()) {
			case "/cuentaAhorro":
				CuentaAhorros cuentaAhorros = this.mapData(req.getInputStream());
				System.out.println(cuentaAhorros.toString());
				cuentaAhorrosService.saveCuenta(cuentaAhorros);
				break;
		
			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
	}

    public CuentaAhorros mapData(ServletInputStream rawData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(rawData, new TypeReference<CuentaAhorros>(){});
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public String objectToString(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

}
