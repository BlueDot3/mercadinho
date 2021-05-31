package br.com.projetoSA.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projetoSA.model.Pedido;

import br.com.projetoSA.repository.PedidoRepository;
import br.com.projetoSA.repository.ProdutoRepository;
import br.com.projetoSA.service.PedidoService;


@Controller
public class PedidoController {
    

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoService pedidoService;
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    @GetMapping("/pedido/list")
	public String listPedidos(Model model) {
		
		model.addAttribute("pedidos", pedidoService.findAll());	
		
		return "pedido/list";
	}

    @GetMapping("/pedido/add")
	public String addPedido(Model model) {

		model.addAttribute("pedido", new Pedido());
		model.addAttribute("produtos", produtoRepository.findAll());
		return "pedido/add";
	}

    @PostMapping("/pedido/save")
	public String saveAddPedido(Pedido pedido) {

		pedidoService.savePedido(pedido);
		
		return "redirect:/pedido/list" ;	
	}
   


}
