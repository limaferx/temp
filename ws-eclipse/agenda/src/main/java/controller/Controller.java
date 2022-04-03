package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;
	//importa a classe para que o servlet use o metodo testeConexao(). Tambem e necessario criar um objeto nessa classe Controller.

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DAO dao = new DAO();
       		//usando como modelo a classe DAO, cria-se um objeto de nome dao.
       		//cria o testeConexao no metodo principal do servlet (o doGet).
       JavaBeans contato = new JavaBeans();
       
    public Controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}
	
	//Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//criar um objeto que recebe os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	//Novo contato
		protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Set variaveis JavaBeans
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			//invocar o metodo inserirContato passando o objeto contato
			dao.inserirContato(contato);
			//redirecionar para o documento agenda.jsp
			response.sendRedirect("main");
		}

}
