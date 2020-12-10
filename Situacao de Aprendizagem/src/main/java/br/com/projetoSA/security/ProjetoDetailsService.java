package br.com.projetoSA.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.PermissaoRepository;
import br.com.projetoSA.repository.UsuarioRepository;

@Component
public class ProjetoDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));

	}

	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {

		Collection<GrantedAuthority> autorizacoes = new ArrayList<>();

		List<Permissao> permissoes = permissaoRepository.findByUsuariosIn(usuario);

		for (Permissao permissao : permissoes) {
			autorizacoes.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
		}

		return autorizacoes;

	}
}