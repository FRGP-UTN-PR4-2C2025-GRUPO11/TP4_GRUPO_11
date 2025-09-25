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

@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		ArrayList<Seguro> lista = new ArrayList<>();
		ArrayList<TipoSeguro> listaTipos = new ArrayList<>();

		if (request.getParameter("listar") != null) {
			// Listamos los seguros
			DaoSeguro daoSeguro = new DaoSeguro();
			lista = daoSeguro.listarSeguros();
			// Listamos la lista de los tipos de datos:
			DaoTipoSeguro daoTipo = new DaoTipoSeguro();
			listaTipos = daoTipo.listarTipoSeguro();

			request.setAttribute("listaTipos", listaTipos);
			request.setAttribute("listaSeguros", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

		ArrayList<Seguro> listaSeguros = null;
		DaoSeguro daoSeguro = new DaoSeguro();
		ArrayList<Seguro> lista = new ArrayList<>();
		ArrayList<TipoSeguro> listaTipos = new ArrayList<>();

		if (request.getParameter("btnFiltrar") != null) {
			int idTipo = Integer.parseInt(request.getParameter("tipoSeguro"));
			if (idTipo != -1) {
				listaSeguros = daoSeguro.listarSeguroPorIdTipo(idTipo);
			} else {
				listaSeguros = daoSeguro.listarSeguros();
			}
			
			DaoTipoSeguro daoTipo = new DaoTipoSeguro();
			listaTipos = daoTipo.listarTipoSeguro();

			request.setAttribute("listaTipos", listaTipos);
			request.setAttribute("listaFiltrada", listaSeguros);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}

		// doGet(request, response);
	}

}
