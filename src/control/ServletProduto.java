package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/prd/listar", "/prd/cadastrar", "/prd/excluir", "/prd/editar", "/prd/buscar" })
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX_URL = "/prd/";

	public ServletProduto() {
		super();
	}
	
	// trata requisições via Método HTTP GET - Pode-se via URL
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals(PREFIX_URL + "listar")) {
			listar(response);
		} else if (request.getServletPath().equals(PREFIX_URL + "buscar")) {
			buscar(response);
		} else if (request.getServletPath().equals(PREFIX_URL + "excluir")) {
			excluir(response);
		}

	}
	
	// trata requisições via Método HTTP POST - Pode-se via Formulário
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals(PREFIX_URL + "cadastrar")) {
			cadastrar(response);
		} else if (request.getServletPath().equals(PREFIX_URL + "editar")) {
			editar(response);
		}
	}

	private void cadastrar(HttpServletResponse response) throws IOException {
		response.getWriter().append("Request via cadastrar");
	}

	private void listar(HttpServletResponse response) throws IOException {
		response.getWriter().append("Request via listar");
	}

	private void buscar(HttpServletResponse response) throws IOException {
		response.getWriter().append("Request via buscar");
	}

	private void editar(HttpServletResponse response) throws IOException {
		response.getWriter().append("Request via editar");
	}

	private void excluir(HttpServletResponse response) throws IOException {
		response.getWriter().append("Request via excluir");
	}
}
