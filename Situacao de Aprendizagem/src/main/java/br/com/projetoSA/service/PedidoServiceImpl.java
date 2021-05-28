package br.com.projetoSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSA.model.Pedido;
import br.com.projetoSA.repository.PedidoRepository;

public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public String viewPedidoById(Long id) {

		pedidoRepository.findById(id);

		return "/pedido/view";
	}

	@Override
	public String savePedido(Pedido pedido) {
		 try {
	           pedidoRepository.save(pedido);
	            return "redirect:/produto/view";
	        } catch (Exception e) { 
	            System.out.println("ERRO: " + e);
	            return "redirect:/produto/edit/" + pedido.getId();
	        }
	}

	@Override
	public String updatePedido(Long id, Pedido pedido) {
		try {
			pedido.setId(id);
			pedidoRepository.save(pedido);
			return "redirect:/pedido/view";
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return "redirect:/pedido/edit";
		}   
	}

	@Override
	public String deletePedido(Long id) {
		 try {
	            pedidoRepository.deleteById(id);
	            return "redirect:/pedido/list";
	        } catch (Exception e) {
	            System.out.println("ERRO: " + e);
				return "redirect:/pedido/edit";
	        }
	}
}
