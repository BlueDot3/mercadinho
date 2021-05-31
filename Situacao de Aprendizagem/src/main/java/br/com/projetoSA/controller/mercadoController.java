package br.com.projetoSA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mercadoController {

	@GetMapping("/mercado/add")
	public String addProduto() {
		return "mercado/add";
	}
	
	
}
