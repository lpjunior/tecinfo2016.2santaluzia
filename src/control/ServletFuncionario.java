package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Funcionario;
import persist.FuncionarioDAO;

/**
 * Servlet implementation class ServletFuncionario
 */
@WebServlet({ "/func/listar", "/func/cadastrar", "/func/excluir", "/func/editar", "/func/buscar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX_URL = "/func/";

	public ServletFuncionario() {
		super();
	}

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX_URL + "cadastrar")) {
			Funcionario funcionario = new Funcionario();

			funcionario.setNmFunc(request.getParameter("nmfunc"));
			funcionario.setEmail(request.getParameter("email"));
			funcionario.setLogin(request.getParameter("login"));
			funcionario.setSenha(request.getParameter("senha"));

			cadastrar(funcionario, response);
			
		} else if (request.getServletPath().equals(PREFIX_URL + "editar")) {
			editar(response);
		}
	}

	private void cadastrar(Funcionario funcionario, HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();
		String msg = "";
		try {
			bd.save(funcionario);
			msg = "Produto cadastrado com sucesso.";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Falha ao gravar o produto";
		}

		response.getWriter().append(msg);
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
