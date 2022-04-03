package atividadeN1.registro.de.contatos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import atividadeN1.registro.de.contatos.controle.ContatosControle;
import atividadeN1.registro.de.contatos.modelo.ContatosModelo;

@WebServlet("/incluirDados")
public class incluirDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gson = new GsonBuilder().create(); //conversor
		gson = new GsonBuilder().setPrettyPrinting().create(); //impressao editada
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		ContatosControle controle = new ContatosControle();
		ContatosModelo contatos = new ContatosModelo();
		contatos.setNome(nome);
		contatos.setTelefone(telefone);
		contatos.setEmail(email);
		
		contatos = controle.dadosIncluir(contatos);
		String contatosJsonString = this.gson.toJson(contatos);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UFT-8");
		out.print(contatosJsonString);
		out.flush();
		
	}

}
