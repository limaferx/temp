package br.edu.pucgoias.sistemaestoque.servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

@WebServlet("/retornaumitem")
public class RetornaUmItem extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EstoqueControle estoqueControle = new EstoqueControle();
	private Gson gson;
	
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
		
		gson = new GsonBuilder().create();
		gson = new GsonBuilder().setPrettyPrinting().create();
		String codigo = req.getParameter("codigo");
		int codInt = Integer.parseInt(codigo);
		
		
		Estoque estoque = new Estoque();
		EstoqueControle ec = new EstoqueControle();
		estoque = ec.getEstoquePorId(codInt);
		
		String estoqueJsonString = this.gson.toJson(estoque);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UFT-8");
		out.print(estoqueJsonString);
		out.flush();
	
	}
}