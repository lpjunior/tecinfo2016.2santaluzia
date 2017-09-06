package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Produto;
import persist.ProdutoDAO;

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
			Produto produto = new Produto();
			
			produto.setNmProduto(request.getParameter("nmproduto"));
			produto.setDescProduto(request.getParameter("descproduto"));
			produto.setPreco(new Double(request.getParameter("preco")));
			produto.setQuantidade(new Integer(request.getParameter("quantidade")));
			
			cadastrar(produto, response);
		} else if (request.getServletPath().equals(PREFIX_URL + "editar")) {
			editar(response);
		}
	}

	private void cadastrar(Produto produto, HttpServletResponse response) throws IOException {
		ProdutoDAO bd = new ProdutoDAO();
		String msg = "";
		try {
			bd.save(produto);
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
