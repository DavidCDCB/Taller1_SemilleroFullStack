package com.cdcb.taller4.controllers;

import java.io.IOException;
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
		int numero;
        //cuentaAhorrosService.createDDL();

		switch (req.getPathInfo()) {
			case "/cuentaAhorro/buscar":
				numero = Integer.parseInt(req.getParameter("numero"));
				CuentaAhorros cuentaAhorro = cuentaAhorrosService.getCuenta(numero);
				if(cuentaAhorro == null) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				} else {
					resp.getWriter().write(this.objectToString(cuentaAhorro));
				}
				break;

			case "/cuentaAhorro":
				List<CuentaAhorros> cuentasAhorro = cuentaAhorrosService.getCuentas();
				resp.getWriter().write(this.objectToString(cuentasAhorro));
				break;

			case "/cuentaCorriente/buscar":
				numero = Integer.parseInt(req.getParameter("numero"));
				CuentaCorriente cuentaCorriente = cuentaCorrienteService.getCuenta(numero);
				if(cuentaCorriente == null) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				} else {
					resp.getWriter().write(this.objectToString(cuentaCorriente));
				}
				break;

			case "/cuentaCorriente":
				List<CuentaCorriente> cuentasCorrientes = cuentaCorrienteService.getCuentas();
				resp.getWriter().write(this.objectToString(cuentasCorrientes));
				break;

			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getContentType();
		if(content != "application/json" && content != null){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		switch (req.getPathInfo()) {
			case "/cuentaAhorro":
				CuentaAhorros cuentaAhorros = this.mapCuentaAhorros(req.getInputStream());
				cuentaAhorrosService.saveCuenta(cuentaAhorros);
				resp.setStatus(HttpServletResponse.SC_CREATED);
				break;

			case "/cuentaCorriente":
				CuentaCorriente cuentaCorriente = this.mapCuentaCorriente(req.getInputStream());
				cuentaCorrienteService.saveCuenta(cuentaCorriente);
				resp.setStatus(HttpServletResponse.SC_CREATED);
				break;
		
			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero;
		boolean modificado = false;
		String content = req.getContentType();
		if(content != "application/json" && content != null){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		switch (req.getPathInfo()) {
			case "/cuentaAhorro/actualizar":
				numero = Integer.parseInt(req.getParameter("numero"));
				CuentaAhorros cuentaAhorros = this.mapCuentaAhorros(req.getInputStream());
				modificado = cuentaAhorrosService.updateCuenta(cuentaAhorros, numero);
				break;

			case "/cuentaCorriente/actualizar":
				numero = Integer.parseInt(req.getParameter("numero"));
				CuentaCorriente cuentaCorriente = this.mapCuentaCorriente(req.getInputStream());
				modificado = cuentaCorrienteService.updateCuenta(cuentaCorriente, numero);
				break;
		
			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
		if(modificado == false) {
			resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numero;
		boolean eliminado = false;
		if(req.getContentType() != "application/json"){
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		switch (req.getPathInfo()) {
			case "/cuentaAhorro/eliminar":
				numero = Integer.parseInt(req.getParameter("numero"));
				eliminado = cuentaAhorrosService.removeCuenta(numero);
				resp.setStatus(HttpServletResponse.SC_OK);
				break;
			
			case "/cuentaCorriente/eliminar":
				numero = Integer.parseInt(req.getParameter("numero"));
				eliminado = cuentaAhorrosService.removeCuenta(numero);
				resp.setStatus(HttpServletResponse.SC_OK);
				break;
			default:
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				break;
		}
		if(eliminado == false) {
			resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
		}
	}

    public CuentaAhorros mapCuentaAhorros(ServletInputStream rawData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(rawData, new TypeReference<CuentaAhorros>(){});
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }


    public CuentaCorriente mapCuentaCorriente(ServletInputStream rawData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(rawData, new TypeReference<CuentaCorriente>(){});
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
