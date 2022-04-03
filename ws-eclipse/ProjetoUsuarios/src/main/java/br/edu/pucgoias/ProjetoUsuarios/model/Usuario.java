package br.edu.pucgoias.ProjetoUsuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //use @Table(name="nomeDaTabela") para nome da tabela diferente do nome da classe
public class Usuario {
	
	@Id // estabelece que esse atributo será chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremental
	private Long id;
	
	@Column(nullable = false) // cria campo que nao pode ter conteudo null
	private String nome;
	
	//Column(name="usuario") - neste caso o campo na tabela nao sera nomeUsuario, mas usuario
	private String nomeUsuario;
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
