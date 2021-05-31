package br.com.projetoSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSA.model.Pedido;
import br.com.projetoSA.model.Produto;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.PedidoRepository;
import br.com.projetoSA.repository.ProdutoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{

	 	@Autowired
	    PedidoRepository pedidoRepository;
	    
	    // Produto list
	    @Override
	    public List<Pedido> findAll() {
	        return pedidoRepository.findAll();
	    }

	    // Save produto

	    @Override
	    public String savePedido(Pedido pedido) {

	        try {
	            pedidoRepository.save(pedido);
	            return "redirect:/pedido/view";
	        } catch (Exception e) { 
	            System.out.println("ERRO: " + e);
	            return "redirect:/pedido/edit/" + pedido.getId();
	        }
	    }

	    // Update produto 
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

	    // Delete produto
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
