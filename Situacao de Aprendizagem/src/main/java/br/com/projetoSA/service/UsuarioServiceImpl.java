package br.com.projetoSA.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.PermissaoRepository;
import br.com.projetoSA.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

	@Autowired
	PermissaoRepository permissaoRepository;

	// Save usuário

    @Override
    public String saveUsuario(Usuario usuario) {

        if(usuarioRepository.findByLogin(usuario.getLogin()) == null && usuarioRepository.findByCpf(usuario.getCpf()) == null && usuarioRepository.findByCnpj(usuario.getCnpj()) == null) {

			if(usuario.getCpf() == null) {
				
				List<Permissao> permissaos = permissaoRepository.findByNome("mercado");

				usuario.setPermissoes(permissaos);

			} else {

				List<Permissao> permissao = permissaoRepository.findByNome("cliente");

				usuario.setPermissoes(permissao);
			}

			usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
			
			usuarioRepository.save(usuario);
			
			return "redirect:/login";

		} else {
			
			System.out.println("Este usuário já existe!");

			return "redirect:/usuario/add";
		}
    }

	// Update usuário

    @Override
    public String updateUsuario(Usuario usuario) {

        try {

			usuarioRepository.save(usuario);

			return "redirect:/usuario/view";

		} catch (Exception e) {
			
			System.out.println("ERRO: " + e);

			return "redirect:/usuario/edit";

		}    
    }

	// Delete usuário

    @Override
    public String deleteUsuario(String login) {

        try {

			usuarioRepository.deleteByLogin(login);

			return "redirect:/usuario/add";

		} catch (Exception e) {
			
			System.out.println("ERRO: " + e);

			return "redirect:/usuario/view";

		}
    }
}
