package br.edu.pucgoias.ProjetoCarros.controller;

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

import br.edu.pucgoias.ProjetoCarros.model.Carros;
import br.edu.pucgoias.ProjetoCarros.repository.CarrosRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarrosRepository carrosRepository;
	
	@PostMapping("/")
	public Carros carro(@RequestBody Carros carros) {
		return this.carrosRepository.save(carros);
	}
	
	@PostMapping("/altera/{id}")
	public Carros carroAltera(@RequestBody Carros carros) {
		return this.carrosRepository.save(carros);
	}
	
	@GetMapping("/lista")
	public List<Carros> lista() {
		return this.carrosRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Carros> carros(@PathVariable("id") Long id) {
		return this.carrosRepository.findById(id);
	}
	
	@GetMapping("/lista/{id}")
	public List<Carros> carrosMaiorQue(@PathVariable("id") Long id) {
		//return this.carrosRepository.buscaTodosMaiorQue(id);
		return this.carrosRepository.findByIdGreaterThan(id);
	}
	
	@GetMapping("/listaano/{ano}")
	public List<Carros> carrosAno(@PathVariable("ano") Integer ano) {
		return this.carrosRepository.findByAno(ano);
	}
	
	@GetMapping("/listamarca/{marca}")
	public List<Carros> carrosMarca(@PathVariable("marca") String marca) {
		return this.carrosRepository.findByMarca(marca);
	}
	
	@GetMapping("/listamodelo/{modelo}")
	public List<Carros> carrosModelo(@PathVariable("modelo") String modelo) {
		return this.carrosRepository.findByModelo(modelo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> carrosDelete(@PathVariable("id") Long id) {
		carrosRepository.deleteById(id);
		return null;
	}

}
