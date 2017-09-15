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

@WebServlet({ "/func/salvar", "/func/excluir", "/func/buscar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX_URL = "/func/";

	public ServletFuncionario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX_URL + "buscar")) {
			if (request.getParameter("id") != null) {
				Long id = Long.parseLong(request.getParameter("id"));
				buscar(id, request, response);
			} else if (request.getParameter("nome") != null) {
				String nome = request.getParameter("nome");
				buscar(nome, request, response);
			} else {
				buscar(request, response);
			}
		} else if (request.getServletPath().equals(PREFIX_URL + "excluir")) {
			Long id = Long.parseLong(request.getParameter("id"));
			excluir(id, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX_URL + "salvar")) {
			Funcionario funcionario = new Funcionario();
			
			if (!request.getParameter("id").equals(""))
				funcionario.setId(Long.parseLong(request.getParameter("id")));

			funcionario.setNmFunc(request.getParameter("nmfunc"));
			funcionario.setEmail(request.getParameter("email"));
			funcionario.setLogin(request.getParameter("login"));
			funcionario.setSenha(request.getParameter("senha"));

			salvar(funcionario, request, response);

		}
	}

	private void salvar(Funcionario funcionario, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO bd = new FuncionarioDAO();
		String msg = "";
		try {
			bd.save(funcionario);
			msg = "Funcionario cadastrado com sucesso.";
			
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Falha ao gravar o funcionario";
		}
		
		request.setAttribute("msg", msg);
		buscar(request, response);
	}

	private void buscar(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			request.setAttribute("funcionario", bd.getFuncionarioById(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/saveFuncionario.jsp").forward(request, response);
	}

	private void buscar(String nome, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			request.setAttribute("funcionarios", bd.findByName(nome));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/listFuncionario.jsp").forward(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			request.setAttribute("funcionarios", bd.getFuncionarios());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/listFuncionario.jsp").forward(request, response);
	}

	private void excluir(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			bd.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "Excluido com sucesso!");
		buscar(request, response);
	}
}
