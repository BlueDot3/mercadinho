package br.com.projetoSA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projetoSA.model.Permissao;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.PermissaoRepository;
import br.com.projetoSA.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@GetMapping("/usuario/add")
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/add";
	}
	
	@PostMapping("/usuario/add/save")
	public String saveUsuario(Usuario usuario) {

			if (usuarioRepository.findByLogin(usuario.getLogin()) == null) {

				usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
				usuarioRepository.save(usuario);

				// List<Permissao> permissao = permissaoRepository.findByNomeLike("padrao");
				// if(permissao == null) {
				// 	permissao.get(0).setNome("padrao");
				// 	permissaoRepository.save(permissao.get(0));
				// }
				// usuario.setPermissoes(permissaoRepository.findByNomeLike("padrao"));
				
			} else {
				System.out.println("Este usuário já existe!");
			}

			return "redirect:/login";

			// String encodedPassword = bCryptPasswordEncoder.encode(usuario.getSenha());
			// usuario.setSenha(encodedPassword);
			// usuarioRepository.save(usuario);
	}

}
