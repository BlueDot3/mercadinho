package br.com.projetoSA.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.projetoSA.model.Pedido;
import br.com.projetoSA.repository.PedidoRepository;
import br.com.projetoSA.service.PedidoServiceImpl;


public class PedidoController {
    
    @Autowired
    PedidoServiceImpl pedidoServiceImpl;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/pedidos/list")
    public String listPedidos(Model model) {

        model.addAttribute("pedidos", pedidoRepository.findAll());

        return "/pedidos/list";
    }

    @GetMapping("/pedidos/view/{id}")
    public String viewPedido(Model model, @PathVariable Long id){

        model.addAttribute("pedido", pedidoRepository.findById(id));

        return "/pedido/view";
    }

    @GetMapping("/pedido/add")
	public String addPedido(Model model) {

		model.addAttribute("pedido", new Pedido());
		return "pedido/add";
	}

    @PostMapping("/pedidos/add")
    public String addPedido(Pedido pedido) {

        return pedidoServiceImpl.savePedido(pedido);
    }

    @GetMapping("/pedido/edit")
	public String editPedido(Model model) {

		model.addAttribute("pedido", new Pedido());
		return "pedido/edit";
	}

    @PutMapping("/pedido/save/{id}")
    public String savePedido(@PathVariable Long id, Pedido pedido) {

        return pedidoServiceImpl.updatePedido(id, pedido);
    }

    @GetMapping("/pedido/delete/{id}")
    public String deletePedido(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoRepository.findById(id));

        return "/pedido/delete";
    }

    @DeleteMapping("/pedido/delete/{id}")
    public String deletePedido(@PathVariable Long id) {

        return pedidoServiceImpl.deletePedido(id);
    }

}
