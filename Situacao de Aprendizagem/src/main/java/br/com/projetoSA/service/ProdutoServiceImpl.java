package br.com.projetoSA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSA.model.Produto;
import br.com.projetoSA.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    // Produto list
    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    // Save produto

    @Override
    public String saveProduto(Produto produto) {

        try {
            produtoRepository.save(produto);
            return "redirect:/produto/view";
        } catch (Exception e) { 
            System.out.println("ERRO: " + e);
            return "redirect:/produto/edit/" + produto.getId();
        }
    }

    // Update produto 
    @Override
    public String updateProduto(Long id, Produto produto) {

        try {
            produto.setId(id);
			produtoRepository.save(produto);
			return "redirect:/produto/view";
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return "redirect:/produto/edit";
		}   
    }

    // Delete produto
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
