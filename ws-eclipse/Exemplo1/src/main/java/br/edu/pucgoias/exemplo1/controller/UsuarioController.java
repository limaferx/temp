package br.edu.pucgoias.exemplo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucgoias.exemplo1.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private List<Usuario> lista = new ArrayList<>();
	
	@GetMapping("/")
	public Usuario usuario() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNome("José");
		usuario.setUsuario("joseusu");
		usuario.setSenha("josesenha");
		return usuario;
	}
	
	@PostMapping("/")
	public Usuario usuario(@RequestBody Usuario usuario ) {
		lista.add(usuario);
		return usuario;
	}
	
	@GetMapping("/lista")
	public List<Usuario> lista() {
		return lista;
	}
	
	@GetMapping("/{id}")
	public Usuario pesquisaId(@PathVariable("id") Integer id) {
		Usuario usuario = null;
		for(int i = 0; i < lista.size(); i++) {
			Integer idx = lista.get(i).getId();
			if(idx == id) {
				usuario = lista.get(i);
			}
		}
		return usuario;
	}
	
	@GetMapping("/ola")
	public String olaMundo() {
		return "Olá, Mundo!";
	}

}
