package atividadeN1.registro.de.contatos.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atividadeN1.registro.de.contatos.dao.ContatosDao;
import atividadeN1.registro.de.contatos.modelo.ContatosModelo;

public class ContatosControle {
	
	private ContatosDao dao = new ContatosDao();
	
	//retorna os dados de todos os contatos
	public List<ContatosModelo> dadosTodos() throws SQLException {
		try {
			List<ContatosModelo> contatos = dao.listarTodos();
			return contatos;
		} catch (Exception e) {
			return new ArrayList<ContatosModelo>();
		}
	}
	
	//retorna um registro por id
	public ContatosModelo dadosPorId(int id) {
		try {
			return dao.obtemPorId(id);
		}
		catch(SQLException e) {
			return null;
		}
	}
	
//inclui um registro no banco de dados
	public ContatosModelo dadosIncluir(ContatosModelo contatos) {
		try {
			dao.incluirDados(contatos);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return contatos;
	}
	
//alterar um registro
	public ContatosModelo dadosAlterar(ContatosModelo contatos) {
		try {
			return dao.alterarDados(contatos);
		} catch (Exception e) {
			System.out.println(e);;
		}
		return contatos;
	}
	
//exclui o registro de um contato pelo id
	public boolean dadosExcluir(int id) {
		try {
			return dao.excluir(id);
		}
		catch(SQLException e) {
			return false;
		}
	}
	
	
	

}
