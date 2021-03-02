package br.com.projetoSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSA.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
  Produto findByPrecoAndNome(String nome, Float preco);
}
