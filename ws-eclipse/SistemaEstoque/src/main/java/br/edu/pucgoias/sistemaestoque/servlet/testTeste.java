package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

@WebServlet("/testTeste")
public class testTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson;
	String descricao;
	List<Estoque> estoques = new ArrayList<>();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gson = new GsonBuilder().create();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		descricao = request.getParameter("descricao");
		
		Estoque estoque = new Estoque();
		EstoqueControle ec = new EstoqueControle();
		estoque.setDescricao(descricao);
		
		
//		//RetornaItemPorDescricao pesq = new RetornaItemPorDescricao();
//		//pesq.descricao = descricao;
//		RequestDispatcher rd = request.getRequestDispatcher("/RetornaItemPorDescricao");
//		rd.forward(request, response);
//		//response.sendRedirect("/RetornaItemPorDescricao");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RetornaItemPorDescricao");
		dispatcher.include(request, response);
		
		String estoqueJsonString = this.gson.toJson(estoques);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(estoqueJsonString);
		out.flush();
	}

}
