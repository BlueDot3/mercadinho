package br.com.projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import br.com.projetoSA.model.Produto;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.ProdutoRepository;
import br.com.projetoSA.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ProdutoService produtoService;
	
	// Lista de produtos

	@GetMapping("/produto/list")
	public String listProduto(Model model) {

		model.addAttribute("produtos", produtoRepository.findAll(Sort.by("nome")));
		return "produto/list";
	}

	// Visualização de um produto 

	@GetMapping("/produto/view/{id}")
	public String viewProduto(@PathVariable long id, Model model) {

		model.addAttribute("produto", produtoRepository.findById(id));
		return "/produto/view";
	}

	// Adicionar produto

	@GetMapping("/produto/add")
	public String addProduto(Model model) {
		model.addAttribute("produto", new Produto());
		return "produto/add";
	}

	@PostMapping("/produto/save")
	public String saveProduto(Produto produto) {

		produtoService.saveProduto(produto);
		return "redirect:/produto/list"; 
	}

	// Editar produto

	@GetMapping("/produto/edit/{id}")
	public String editProduto(@PathVariable long id, Model model) {
		
		model.addAttribute("produto", produtoRepository.findById(id));
		return "produto/edit";
		
	}
	
	@PutMapping("/produto/save/{id}")
	public String updateProduto(@PathVariable Long id, Produto produto) {
		
		return produtoService.updateProduto(id, produto);
	}
	
	

	// Deletar produto

	
	@GetMapping("/produto/delete/{id}")
	public String deleteProduto(@PathVariable long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/produto/list";
	}
}
