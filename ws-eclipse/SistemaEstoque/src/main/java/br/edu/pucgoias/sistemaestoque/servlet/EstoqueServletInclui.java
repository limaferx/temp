package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.dao.BaseDao;
import br.edu.pucgoias.sistemaestoque.dao.EstoqueDao;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

@WebServlet("/EstoqueServletInclui")
public class EstoqueServletInclui extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	//declara uma variavel para o conversor
    private Gson gson; 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		gson = new GsonBuilder().create();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		String descricao = request.getParameter("descricao");

		List<Estoque> estoques = new ArrayList<>();
		EstoqueControle ec = new EstoqueControle();
		estoques = ec.buscaEstoquePorNome(descricao);
		
		if (estoques.isEmpty()) { //verifica se o array tem algum dado. se for um array vazio, envia a mensagem.
			PrintWriter out = response.getWriter();
			out.print("Item nao consta no estoque.");
		} else { //se o array contem dados, lista os itens no estoque com a descricao digitada.
			String estoqueJsonString = this.gson.toJson(estoques);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UFT-8");
			out.print(estoqueJsonString);
			out.flush();
		}

	}
    
    //incluir um registro com o metodo doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		gson = new GsonBuilder().create(); //cria um conversor para Json
		gson = new GsonBuilder().setPrettyPrinting().create(); //edita o formato de exibicao Json
		
		//declara as variaveis que vao receber os parametros de inclusao
		String descricao = request.getParameter("descricao"); //variavel para receber o parametro descricao. o parametro recebe apenas String.
		String precounit = request.getParameter("precounit"); //variavel para receber o parametro precounit. o parametro recebe apenas String.
		String quantidade = request.getParameter("quantidade"); //variavel para receber o parametro quantidade. o parametro recebe apenas String.
		
		//converte as variaveis diferentes de String
		double codprecounit = Double.parseDouble(precounit); //tudo que for diferente de String precisa ser convertido. nesse caso, convert a String da variavel precounit para double.
		double codquantidade = Double.parseDouble(quantidade); //converte a String da variavel quantidade para double.
		
		Estoque estoque = new Estoque(); //instancia um objeto do tipo Estoque para guardar as variaveis que tem os parametros.
		EstoqueControle ec = new EstoqueControle(); //instancia um objeto do tipo EstoqueControle para executar um metodo.
		estoque.setDescricao(descricao); //o objeto estoque (do tipo Estoque) recebe a variavel descricao com o parametro a incluir
		estoque.setPrecounit(codprecounit); //recebe a variavel codprecounit (conversao de precounit) que contem o parametro preco
		estoque.setQuantidade(codquantidade); //recebe a variavel codquantidade (conversao de quantidade) que contem o parametro quantidade
		
		ec.salvarEstoque(estoque); //o objeto ec (do tipo EstoqueControle) chama o metodo salvarEstoque(estoque).
		/*
		 * o metodo salvarEstoque(estoque) leva objeto (estoque) com os parametros para a camada controle.
		 * a camada EstoqueControle cria um objeto ed (do tipo EstoqueDao) e chama o metodo ed.salvarEstoque().
		 * ed.salvarEstoque() recebe os parametros (estoque) e aciona a camada EstoqueDao.
		 * EstoqueDao cria um objeto bd (do tipo BaseDao) para fazer a conexao com o banco de dados.
		 * o metodo salvarEstoque() recebe os parametros (estoque) e executa o algoritmo.
		 * o objeto bd (do tipo BaseDao) faz a conexao com o banco de dados; Connection conn = bd.getConnection();
		 * escreve o comando a ser executado no SQL: String sql = "insert into estoque (descricao, precounit, quantidade) values (?, ?, ?,)"
		 * entrega o comando para o PreparedStatement: PreparedStatement pstmt = (sql);
		 * insere os parametros nas interrogacoes do comando sql: ex.: pstmt.setString(1, estoque.getDescricao()) altera a primeira interrogacao para o valor de descricao do registro
		 * executa o comando: pstmt.executeUpdate();
		 * encerra a conexao com o banco de dados: conn.close(); 
		 */
		
		String estoqueJsonString = this.gson.toJson(estoque);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(estoqueJsonString);
		out.flush();
	
	}
}
