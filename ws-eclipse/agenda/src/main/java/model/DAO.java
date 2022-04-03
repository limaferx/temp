package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/* Modulo de conexao*/
	//Parametros de conexao
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/dbagenda";
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
	
	/** CRUD CREATE **/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?, ?, ?)";
		try {
			//abrir a conexao
			Connection con = conectar();
			//preparar a query para a execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			//substituir os parametros (as interrogacoes) pelo conteudo das variaveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			//executar a query
			pst.executeUpdate();
			//encerrar a conexao com o banco de dados
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		//cria um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//o laco de repeticao abaixo sera executado enquanto houver contatos
			while (rs.next()) {
				//variaveis de apoio que recebem os dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				//armazenar os contatos no vetor (popular o array)
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	

}
