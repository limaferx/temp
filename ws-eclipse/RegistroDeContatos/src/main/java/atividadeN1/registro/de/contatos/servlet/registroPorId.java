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

@WebServlet("/registroPorId")
public class registroPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gson = new GsonBuilder().create();
   		gson = new GsonBuilder().setPrettyPrinting().create();
   		
   		ContatosControle controle = new ContatosControle();
   		ContatosModelo contatos = new ContatosModelo();
   		String id = request.getParameter("id");
   		int codid = Integer.parseInt(id);
   		
   		try {
			contatos = controle.dadosPorId(codid);
			String contatosJsonString = this.gson.toJson(contatos);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UFT-8");
			out.print(contatosJsonString);
			out.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
