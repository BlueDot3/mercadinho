package br.com.projetoSA.service;

import br.com.projetoSA.model.Pedido;
import java.util.List;

;

public interface PedidoService{
	
	public List<Pedido> findAll();
    
	
	public String savePedido(Pedido pedido);

	
	public String updatePedido(Long id, Pedido Pedido);

	
	public String deletePedido(Long id);

	
	
}
