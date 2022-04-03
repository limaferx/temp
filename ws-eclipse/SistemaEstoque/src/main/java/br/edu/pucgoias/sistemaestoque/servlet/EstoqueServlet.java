package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;


@WebServlet("/estoques")
public class EstoqueServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EstoqueControle estoqueControle = new EstoqueControle();
	private Gson gson;
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Estoque> estoques = estoqueControle.getEstoques();
			String estoquesString = estoques.toString();
			resp.getWriter().write(estoquesString);
			resp.getWriter().write("<br>");
			resp.getWriter().write("<br>");
			
			gson = new GsonBuilder().create();
			gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray jarray = gson.toJsonTree(estoques).getAsJsonArray();
			JsonObject jsonObject = new JsonObject();
			jsonObject.add("estoques", jarray);
			
			//return jsonObject.toString();
			resp.getWriter().write(jsonObject.toString());
			PrintWriter pw = resp.getWriter();
			pw.println(" ");
			pw.println(gson.toJson(estoques));
			
			
			
		} catch (SQLException e) {
			
			
		}
	}
}