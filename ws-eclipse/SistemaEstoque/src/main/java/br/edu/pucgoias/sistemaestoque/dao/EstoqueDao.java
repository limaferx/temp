package br.edu.pucgoias.sistemaestoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

public class EstoqueDao {
	
	BaseDao bd = new BaseDao();
	
	public Estoque obtemEstoqueViaId(int id) throws SQLException {
		
		Estoque estoque = new Estoque();
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			
			conn = bd.getConnection();
			
			pstmt = conn.prepareStatement("select * from estoque where id=?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				
				estoque = this.criaEstoque(rs);
			}
		}
		finally {
			if (pstmt != null) {
				
				pstmt.close();
			}
			if (pstmt != null) {
				
				conn.close();
			}
		}
		return estoque;
	}
	
	public Estoque criaEstoque(ResultSet rs) throws SQLException {
		
		Estoque estoque = new Estoque();
		estoque.setDescricao(rs.getString("descricao"));
		estoque.setId(rs.getInt("id"));
		estoque.setPrecounit(rs.getDouble("precounit"));
		estoque.setQuantidade(rs.getDouble("quantidade"));
		return estoque;
	}
	
	public List<Estoque> obtemEstoquesGetNome(String nome) throws SQLException {
		
		List<Estoque> estoques = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estoque estoque = null;
		try {
		
			conn = bd.getConnection();
			pstmt = conn.prepareStatement("select * from estoque where lower(descricao) like ?");
			pstmt.setString(1, "%"+nome.toLowerCase()+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				estoque = this.criaEstoque(rs);
				estoques.add(estoque);
			}
		}
		finally {
			
			if (pstmt != null) {
			
				pstmt.close();
				conn.close();
			}
		}
		return estoques;

}

	public List<Estoque> obtemTodos() throws SQLException {
		
		List<Estoque> estoques = new ArrayList<>();
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estoque estoque = null;
		try {
			
			conn = bd.getConnection();
			pstmt = conn.prepareStatement("select * from estoque order by descricao");
			rs= pstmt.executeQuery();
			while (rs.next()) {
				
				estoque = this.criaEstoque(rs);
				estoques.add(estoque);
			}
			return estoques;
		}
		finally {
			
			if (pstmt != null) {
			
				pstmt.close();	
			}
			if (pstmt != null) {
			
				conn.close();
			}
		}

	}
	
	public void salvarEstoque(Estoque estoque) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean achouRegistro = false;
		String sql = "";
		try {
			
			conn = bd.getConnection();
			
			if (estoque.getId() == 0) {
				
				sql = "insert into estoque (descricao, precounit, quantidade) values (?, ?, ?)";
				pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}
			else {
				
				sql = "update estoque set descricao = ?, precounit = ?, quantidade = ? where id = ?";
				pstmt = conn.prepareStatement(sql);
			}
			
			pstmt.setString(1, estoque.getDescricao());
			pstmt.setDouble(2, estoque.getPrecounit());
			pstmt.setDouble(3, estoque.getQuantidade());
			pstmt.executeUpdate();
			if (estoque.getId() != 0) {
				
				//update
				int idAux = pstmt.executeUpdate();
				if (idAux == 0) {
					
					throw new SQLException("Erro ao atualizar estoque.");
				}
				//caso inseriu, obter id auto incremental
				if (estoque.getId() == 0) {
					
					Integer idInserir = getGeneratedId(pstmt);
					estoque.setId(idInserir);
				}
			}
		}
		finally {
			
			if (pstmt != null) {
			
				pstmt.close();	
			}
			if (pstmt != null) {
			
				conn.close();
			}
		}
	}
	
	public static Integer getGeneratedId(Statement stmt) throws SQLException {
		
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			
			Integer id = rs.getInt(1);
			return id;
		}
		return 0;
		
	}
	
	public boolean alterar(Estoque e) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean retorno = true;
		String sql = "update estoque set descricao = ? where id = ?";
		try {
			
			conn = bd.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getDescricao());
			pstmt.setInt(2, e.getId());
			
			int conta = pstmt.executeUpdate();
			retorno = conta > 0;
			
		}
		catch (SQLException eee) {
			
			retorno = false;
		}
		finally {
			
			if (pstmt != null) {
			
				pstmt.close();	
			}
			if (pstmt != null) {
			
				conn.close();
			}
		}
		return retorno;
	}
	
	public boolean excluir(int id) throws SQLException {
		
		Connection conn = bd.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
			conn = bd.getConnection();
			
			pstmt = conn.prepareStatement("delete from estoque where id = ?");
		
			pstmt.setInt(1, id);
			int conta = pstmt.executeUpdate();
			boolean retorno = conta > 0;
			return retorno;
		}
		finally {
			
			if (pstmt != null) {
			
				pstmt.close();	
			}
			if (pstmt != null) {
			
				conn.close();
			}
		}
	}
	
	
}