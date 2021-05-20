package br.com.projetoSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSA.model.Mercado;




public interface MercadoRepository extends JpaRepository<Mercado, Long> {

	Mercado findByLogin(String login);
	
	Mercado findByNome(String nome);
	
	Mercado findByCnpj(String cnpj);
}
