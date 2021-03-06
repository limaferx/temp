package br.edu.pucgoias.ProjetoUsuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.pucgoias.ProjetoUsuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	
	@Query("SELECT u from Usuario u where u.id >:id")
	public List<Usuario> buscaTodosMaiorQue(@Param("id") Long id);
	
	public List<Usuario> findByIdGreaterThan(Long id);
	
	public List<Usuario> findByNomeIgnoreCase(String nome);

}
