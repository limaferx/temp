package br.edu.pucgoias.ProjetoUsuarios.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucgoias.ProjetoUsuarios.model.Usuario;
import br.edu.pucgoias.ProjetoUsuarios.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired //injeta/cria referencia automatica de objetos da classe UsusarioRepository
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/")
	public Usuario usuario(@RequestBody Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	@GetMapping("/lista")
	public List<Usuario> lista() {
		return this.usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> usuario(@PathVariable("id") Long id) {
		return this.usuarioRepository.findById(id);
	}
	
	@GetMapping("/lista/{id}")
	public List<Usuario> usuarioMaiorQue(@PathVariable("id") Long id) {
		//return this.usuarioRepository.buscaTodosMaiorQue(id);
		return this.usuarioRepository.findByIdGreaterThan(id);
	}
	
	@GetMapping("/listanome/{nome}")
	public List<Usuario> usuarioNome(@PathVariable("nome") String nome) {
		return this.usuarioRepository.findByNomeIgnoreCase(nome);
	}
	
	@DeleteMapping(("/{id}"))
	public ResponseEntity<Long> usuarioDelete(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
		return null;
	}
	
}
