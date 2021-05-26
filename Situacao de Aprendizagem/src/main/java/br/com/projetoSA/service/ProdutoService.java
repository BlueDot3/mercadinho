package br.com.projetoSA.service;

import java.util.List;


import br.com.projetoSA.model.Produto;

public interface ProdutoService {
	
	public List<Produto> findAll();
    
	public String saveProduto(Produto produto);

	public String updateProduto(Long id, Produto produto);

	public String deleteProduto(Long id);
}
