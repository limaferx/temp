package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

@WebServlet("/RetornaItemPorDescricao")
public class RetornaItemPorDescricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson;
	String descricao;
	List<Estoque> estoques = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		gson = new GsonBuilder().create();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		descricao = request.getParameter("descricao");

		//List<Estoque> estoques = new ArrayList<>();
		EstoqueControle ec = new EstoqueControle();
		estoques = ec.buscaEstoquePorNome(descricao);
		
		String estoqueJsonString = this.gson.toJson(estoques);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UFT-8");
		out.print(estoqueJsonString);
		out.flush();

	}
}