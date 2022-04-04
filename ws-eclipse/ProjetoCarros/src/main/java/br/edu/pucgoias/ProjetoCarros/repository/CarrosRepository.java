package br.edu.pucgoias.ProjetoCarros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.pucgoias.ProjetoCarros.model.Carros;

public interface CarrosRepository extends JpaRepository<Carros, Long> {
	
	@Query("SELECT u from Carros u where u.id >:id")
	public List<Carros> buscaTodosMaiorQue(@Param("id") Long id);
	
	public List<Carros> findByIdGreaterThan(Long id);
	
	public List<Carros> findByAno(Integer ano);
	
	public List<Carros> findByMarca(String marca);
	
	public List<Carros> findByModelo(String modelo);

}
