package br.com.projetoSA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSA.model.Mercado;
import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.model.Usuario;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	public List<Permissao> findByUsuariosIn(Usuario ... usuario);
	


	public Permissao findByIdIsNull();

	public List<Permissao> findByNomeLike(String nome);

	List<Permissao> findByNome(String nome);
	
}