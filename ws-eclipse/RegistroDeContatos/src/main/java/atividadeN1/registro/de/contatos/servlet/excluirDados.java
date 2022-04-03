package atividadeN1.registro.de.contatos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import atividadeN1.registro.de.contatos.controle.ContatosControle;
import atividadeN1.registro.de.contatos.modelo.ContatosModelo;

@WebServlet("/excluirDados")
public class excluirDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson;
       
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gson = new GsonBuilder().create();
   		gson = new GsonBuilder().setPrettyPrinting().create();
   		
   		ContatosControle controle = new ContatosControle();
   		ContatosModelo contatos = new ContatosModelo();
   		String id = request.getParameter("id");
   		int codid = Integer.parseInt(id);
   		
   		controle.dadosExcluir(codid);
   		}
	}
