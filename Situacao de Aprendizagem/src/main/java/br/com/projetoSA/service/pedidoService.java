package br.com.projetoSA.service;

import java.util.List;

import br.com.projetoSA.model.Pedido;


public interface pedidoService {
    
	public List<Pedido> findAll();
    
	public String savePedido(Pedido pedido);

	public String updatePedido(Long id, Pedido Pedido);

	public String deletePedido(Long id);

	
	
}
