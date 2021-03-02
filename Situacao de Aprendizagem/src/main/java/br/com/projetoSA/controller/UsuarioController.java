package br.com.projetoSA.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario/view")
	public String viewUsuario(Model model, @CurrentSecurityContext(expression="authentication.name") String login) {

		model.addAttribute("usuario", usuarioRepository.findByLogin(login));

		return "usuario/view";
	}

	@GetMapping("/usuario/add")
	public String addUsuario(Model model) {

		model.addAttribute("usuario", new Usuario());
		return "usuario/add";
	}
	
	@PostMapping("/usuario/save")
	public String saveUsuario(Usuario usuario) {

		if (usuarioRepository.findByLogin(usuario.getLogin()) == null || usuarioRepository.findByCpf(usuario.getCpf()) == null) {

			usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
			
			usuarioRepository.save(usuario);
			
			return "redirect:/login";

		} else {
			
			System.out.println("Este usuário já existe!");

			return "redirect:/usuario/add";
		}	
	}

	@PostMapping("/usuario/delete")
	public String deleteUsuario(@CurrentSecurityContext(expression="authentication.name") String login) { 

		try {

			usuarioRepository.deleteByLogin(login);

			return "redirect:/usuario/add";

		} catch (Exception e) {
			
			System.out.println("ERRO: " + e);

			return "redirect:/usuario/view";

		}	
	}
}
