package br.edu.pucgoias.TesteSwagger.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

	@GetMapping("/")
	public String mensagem() {
		return "Olá, Swagger!";
	}
	
	@GetMapping("/lista")
	public ArrayList<String> elementos(){
		ArrayList<String> lista = new ArrayList<String>();
		for(int i = 0; i <= 5; i++) {
			lista.add("elemento" + i);
		}
		return lista;
	}
}
