package br.edu.pucgoias.sistemaestoque.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.pucgoias.sistemaestoque.dao.EstoqueDao;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

public class EstoqueControle {
	
	private EstoqueDao ed = new EstoqueDao();
	
	//retorna todos os itens do estoque
	public List<Estoque> getEstoques() throws SQLException {
		
		try {
			
			List<Estoque> estoques = ed.obtemTodos();
			return estoques;
		}
		catch(SQLException e) {
			
			return new ArrayList<Estoque>();
		}
	}
	
	//retorna item do estoque pelo id
	public Estoque getEstoquePorId(int id) {
		
		try {
			
			return ed.obtemEstoqueViaId(id);
		}
		catch(SQLException e) {
			
			return null;
		}
	}
	
	//exclui item do estoque pelo id
	public boolean excluiEstoque(int id) {
		
		try {
			
			return ed.excluir(id);
		}
		catch(SQLException e) {
			
			return false;
		}
	}
	
	//salva item no estoque
	public boolean salvarEstoque(Estoque estoque) {
		try {
			ed.salvarEstoque(estoque);
			return true;
		}
		catch(SQLException e) {
			
			return false;
		}
	}
	
	//busca estoque pela descricao
	public List<Estoque> buscaEstoquePorNome(String nome) {
		
		try {
			
			return ed.obtemEstoquesGetNome(nome);
		}
		catch(SQLException e) {
			
			return null;
		}
	}
}
