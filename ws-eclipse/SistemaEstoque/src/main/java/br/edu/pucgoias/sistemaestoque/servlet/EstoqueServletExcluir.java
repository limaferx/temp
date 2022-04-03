package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;

@WebServlet("/EstoqueServletExcluir")
public class EstoqueServletExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson;

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gson = new GsonBuilder().create(); //conversor
		gson = new GsonBuilder().setPrettyPrinting().create(); //edita o texto

		String codigo = request.getParameter("codigo"); //declara variavel do tipo String (exigencia do parametro)
		int intcodigo = Integer.parseInt(codigo); //converte para 
		boolean estoque = true;
		EstoqueControle ec = new EstoqueControle();
		estoque = ec.excluiEstoque(intcodigo);
		
		String estoqueJsonString = this.gson.toJson(estoque);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(estoqueJsonString);
		out.flush();

	}

}
