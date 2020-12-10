package br.com.projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.projetoSA.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto/list")
	public String listProduto(Model model) {
		model.addAttribute("produtos", produtoRepository.findAll(Sort.by("nome")));
		return "produto/list";
	}
	
	@GetMapping("/produto/view/{id}")
	public String viewProduto(@PathVariable long id, Model model) {
		model.addAttribute("produto", produtoRepository.findById(id));
		return "/produto/view";
	}
	
	
	@GetMapping("/produto/edit")
	public String editProduto() {
		return "produto/edit";
	}
	
	@GetMapping("/produto/add")
	public String addProduto() {
		return "produto/add";
	}
}
