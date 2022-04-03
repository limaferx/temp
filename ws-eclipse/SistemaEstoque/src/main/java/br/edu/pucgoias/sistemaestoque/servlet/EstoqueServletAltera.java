package br.edu.pucgoias.sistemaestoque.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;

import br.edu.pucgoias.sistemaestoque.dao.EstoqueDao;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alterar")
public class EstoqueServletAltera extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EstoqueControle estoqueControle = new EstoqueControle();
	private Gson gson;
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		gson = new GsonBuilder().create();
		gson = new GsonBuilder().setPrettyPrinting().create();
		String codigo = req.getParameter("codigo");
		String descricao = req.getParameter("descricao");
		
		int codInt = Integer.parseInt(codigo);
		
		EstoqueDao ed = new EstoqueDao();
		Estoque estoque = new Estoque();
		EstoqueControle ec = new EstoqueControle();
		estoque = ec.getEstoquePorId(codInt);
		estoque.setDescricao(descricao);
		boolean retorno = true;
		
		try {
			retorno = ed.alterar(estoque);
		} catch (SQLException e) {
			e.printStackTrace();
			retorno = false;
			
		}
		
		String estoqueJsonString = this.gson.toJson(estoque);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(estoqueJsonString);
		out.flush();
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
}