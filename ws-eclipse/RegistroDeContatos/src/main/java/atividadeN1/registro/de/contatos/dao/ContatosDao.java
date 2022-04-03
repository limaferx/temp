package atividadeN1.registro.de.contatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import atividadeN1.registro.de.contatos.modelo.ContatosModelo;

public class ContatosDao {
	
	/* Modulo de conexao*/
	//Parametros de conexao
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/registro_de_contatos";
	private String user = "root";
	private String password = "";
	
	//Metodo de conexao
	
	private Connection conectar() {
		Connection con = null;
			//cria um objeto para conectar com o banco de dados.
		try {
			//o uso de try catch e fundamental para a conexao com o banco de dados.
			Class.forName(driver);
				//comando para ler o driver do banco de dados, informação da variavel que foi criada.
			con = DriverManager.getConnection(url, user, password);
				//con estabelece uma secao com o banco de dados.
				//DriverManager gerencia o driver.
				//.getConnection obtem os parametros de conexao.
				// url, user e password sao as variaveis definidas que permitirao acessar o banco de dados.
			return con;
				//estabelece a conexao.
		} catch (Exception e) {
			System.out.println(e);
				//para apresentar a mensagem em caso de erro.
			return null;
			
		}
	}


//Listar todos (doGet)
	public List<ContatosModelo> listarTodos() throws SQLException {
	
	List<ContatosModelo> listaContatos = new ArrayList<>();
	ContatosDao dao = new ContatosDao();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ContatosModelo contatos = null;
	try {
		
		con = dao.conectar();
		pstmt = con.prepareStatement("select * from dados order by nome");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			
			contatos = this.criaLista(rs);
			listaContatos.add(contatos);
		}
		return listaContatos;
	}
	finally {
		
		if (pstmt != null) {
			pstmt.close();
			con.close();
		}
	}
		
}
		
//Cria a lista de contatos
	public ContatosModelo criaLista(ResultSet rs) throws SQLException {
		ContatosModelo contatos = new ContatosModelo();
		contatos.setId(rs.getInt("id"));
		contatos.setNome(rs.getString("nome"));
		contatos.setTelefone(rs.getString("telefone"));
		contatos.setEmail(rs.getString("email"));
		return contatos;
	}
	
//Obter um registro por id
	public ContatosModelo obtemPorId(int id) throws SQLException {
		ContatosDao dao = new ContatosDao();
		ContatosModelo contatos = new ContatosModelo();
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = dao.conectar();
			pstmt = con.prepareStatement("select * from dados where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				contatos = this.criaLista(rs);
			}
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
				con.close();
			}
		}
		return contatos;
	}
	
//Incluir (doPost)
	public void incluirDados(ContatosModelo contatos) throws SQLException {
		ContatosDao dao = new ContatosDao();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = dao.conectar();
			if (contatos.getId() == 0) {
				sql = "insert into dados (nome, telefone, email) values (?, ?, ?)";
				pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, contatos.getNome());
				pstmt.setString(2, contatos.getTelefone());
				pstmt.setString(3, contatos.getEmail());
				pstmt.executeUpdate();
			}
			else {
				throw new SQLException("Erro ao atualizar estoque.");
			}
		}
		finally {
			
			if (pstmt != null) {
				pstmt.close();	
				con.close();
			}
		}
	}
	
//Alterar (doPut)
	public ContatosModelo alterarDados(ContatosModelo contatos) throws SQLException {
		ContatosDao dao = new ContatosDao();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			if(contatos.getNome() != null) {
				sql = "update dados set nome = ? where id = ?";
				con = dao.conectar();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, contatos.getNome());
				pstmt.setInt(2, contatos.getId());
				pstmt.executeUpdate();
			} else if (contatos.getTelefone() != null) {
				sql = "update dados set telefone = ? where id = ?";
				con = dao.conectar();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, contatos.getTelefone());
				pstmt.setInt(2, contatos.getId());
				pstmt.executeUpdate();
			} else if (contatos.getEmail() != null) {
				sql = "update dados set email = ? where id = ?";
				con = dao.conectar();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, contatos.getEmail());
				pstmt.setInt(2, contatos.getId());
				pstmt.executeUpdate();
			}
//			con = dao.conectar();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, contatos.getNome());
//			pstmt.setString(2, contatos.getTelefone());
//			pstmt.setString(3, contatos.getEmail());
//			pstmt.setInt(4, contatos.getId());
//			pstmt.executeUpdate();
//			return contatos;
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			
			if (pstmt != null) {
				pstmt.close();	
				con.close();
			}
		}
		return contatos;
	}
	
//Excluir
	public boolean excluir(int id) throws SQLException {
		ContatosDao dao = new ContatosDao();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dao.conectar();
			pstmt = con.prepareStatement("delete from dados where id = ?");
			pstmt.setInt(1, id);
			int conta = pstmt.executeUpdate();
			boolean retorno = conta > 0;
			return retorno;
		}
		finally {
			if (pstmt != null) {
				pstmt.close();
				con.close();
			}
		}
	}
	
}