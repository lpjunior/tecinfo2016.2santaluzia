package br.senac.rj.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.rj.entidade.Contato;

@WebServlet(urlPatterns = {"/cadastrar", "/editar", "/listar"})
public class ServletContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContato() {
        super();
    }

    // Método HTTP GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}
	
    // Método HTTP POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cadastrar(request, response);
		
	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		// request.getParameter - resgata os dados do campo
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		
		// atribuo o contato no cabeçalho da requisição
		request.setAttribute("contatoCad", contato);
		
		// encaminho(despacho) a requisição para que de direito
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contato> contatos = new ArrayList<Contato>();
		Contato contato = null;
		
		// request.getParameter - resgata os dados do campo
		for(int i = 1; i <= 10; i++) {
			contato = new Contato();
			contato.setId(i);
			contato.setNome("Contato " + i);
			contato.setEmail("contato" + i + "@gmail.com");
			contato.setTelefone("1234567" + i);
			contatos.add(contato);
		}
		
		request.setAttribute("listaContatos", contatos);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}
}
