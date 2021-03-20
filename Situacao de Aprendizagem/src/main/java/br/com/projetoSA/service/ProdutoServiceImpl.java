package br.com.projetoSA.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoSA.model.Produto;
import br.com.projetoSA.repository.ProdutoRepository;

public class ProdutoServiceImpl implements ProdutoService{
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public String saveAddProduto(Produto produto) {

        try {

            produtoRepository.save(produto);

            return "redirect:/produto/view";

        } catch (Exception e) {
            
            System.out.println("ERRO: " + e);

            return "redirect:/produto/edit/" + produto.getId();
        }
    }

    @Override
    public String saveEditProduto(Long id, Produto produto) {

        try {

            produto.setId(id);

			produtoRepository.save(produto);

			return "redirect:/produto/view";

		} catch (Exception e) {
			
			System.out.println("ERRO: " + e);

			return "redirect:/produto/edit";

		}   
    }

    @Override
    public String deleteProduto(Long id) {

        try {
            
            produtoRepository.deleteById(id);

            return "redirect:/produto/list";

        } catch (Exception e) {
            
            System.out.println("ERRO: " + e);

			return "redirect:/produto/edit";
        }
    }
}
