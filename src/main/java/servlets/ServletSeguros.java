package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entidad.*;

@WebServlet("/ServletSeguros")
public class ServletSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSeguros() {
		super();
	}

	private ArrayList<TipoSeguro> uploadTipoSeguro() {
		ArrayList<TipoSeguro> listTypes = null;
		DaoTipoSeguro daoType = new DaoTipoSeguro();
		listTypes = daoType.listarTipoSeguro();
		return listTypes;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		ArrayList<TipoSeguro> listTipos = null;
	
		if (request.getParameter("addSeguro") != null) {

			listTipos = this.uploadTipoSeguro();
			request.setAttribute("listTipos", listTipos);
			RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguros.jsp");
			rd.forward(request, response);
		}

		//Agregar Seguro
		if(request.getParameter("btnSend") != null){
			Seguro seguro = new Seguro();
			seguro.setDescripcion(request.getParameter("description"));
			seguro.setIdTipo(Integer.parseInt(request.getParameter("typeSeguro")));
			seguro.setCostoContrato(Float.parseFloat(request.getParameter("constoContratacion")));;
			seguro.setCostoAsegurado(Float.parseFloat(request.getParameter("maxConstoAsegurado")));;
			
			DaoSeguro dao = new DaoSeguro();
		    int filas = dao.agregarSeguro(seguro);
		    
		    request.setAttribute("cantFilas", filas);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguros.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		doGet(request, response);
	}

}
