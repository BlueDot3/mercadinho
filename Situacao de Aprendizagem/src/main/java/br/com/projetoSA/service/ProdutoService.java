package br.com.projetoSA.service;

import br.com.projetoSA.model.Produto;

public interface ProdutoService {
    
    String saveProduto(Produto produto);

    String updateProduto(Long id, Produto produto);

    String deleteProduto(Long id);
}
