package br.senac.rj.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.rj.entidade.Contato;

@WebServlet(urlPatterns = {"/cadastrar", "/editar"})
public class ServletContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContato() {
        super();
    }

    // M�todo HTTP GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
    // M�todo HTTP POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		// request.getParameter - resgata os dados do campo
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		
		// atribuo o contato no cabe�alho da requisi��o
		request.setAttribute("contatoCad", contato);
		
		// encaminho(despacho) a requisi��o para que de direito
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
}
