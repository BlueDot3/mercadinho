package br.com.projetoSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSA.model.Produto;
import br.com.projetoSA.model.Usuario;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
 
}
