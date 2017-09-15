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

@WebServlet({ "/func/listar", "/func/salvar", "/func/excluir", "/func/buscar" })
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
			if (request.getParameter("id") != null) {
				Long id = Long.parseLong(request.getParameter("id"));
				buscar(id, response);
			} else if (request.getParameter("nome") != null) {
				String nome = request.getParameter("nome");
				buscar(nome, response);
			}
		} else if (request.getServletPath().equals(PREFIX_URL + "excluir")) {
			Long id = Long.parseLong(request.getParameter("id"));
			excluir(id, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX_URL + "salvar")) {
			Funcionario funcionario = new Funcionario();

			if (request.getParameter("id") != null)
				funcionario.setId(Long.parseLong(request.getParameter("id")));

			funcionario.setNmFunc(request.getParameter("nmfunc"));
			funcionario.setEmail(request.getParameter("email"));
			funcionario.setLogin(request.getParameter("login"));
			funcionario.setSenha(request.getParameter("senha"));

			salvar(funcionario, response);

		}
	}

	private void salvar(Funcionario funcionario, HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();
		String msg = "";
		try {
			bd.save(funcionario);
			msg = "Funcionario cadastrado com sucesso.";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Falha ao gravar o funcionario";
		}

		response.getWriter().append(msg);
	}

	private void listar(HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			bd.getFuncionarios().forEach(funcionario -> {
				try {
					response.getWriter().append(funcionario.toString() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buscar(Long id, HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();
		Funcionario f = null;

		try {
			f = bd.getFuncionarioById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append(f.toString());
	}

	private void buscar(String nome, HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			bd.findByName(nome).forEach(funcionario -> {
				try {
					response.getWriter().append(funcionario.toString() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void excluir(Long id, HttpServletResponse response) throws IOException {
		FuncionarioDAO bd = new FuncionarioDAO();

		try {
			bd.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Excluido com sucesso!");
	}
}
