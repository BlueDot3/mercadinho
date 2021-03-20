package br.com.projetoSA.service;

import br.com.projetoSA.model.Produto;

public interface ProdutoService {
    
    String saveAddProduto(Produto produto);

    String saveEditProduto(Long id, Produto produto);

    String deleteProduto(Long id);
}
