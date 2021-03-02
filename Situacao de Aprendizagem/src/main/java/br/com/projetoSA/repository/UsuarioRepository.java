package br.com.projetoSA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSA.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);

  Usuario deleteByLogin(String login);

  Usuario findByCpf(String cpf);

  // public List<Usuario> findBySenha(String senha);

}