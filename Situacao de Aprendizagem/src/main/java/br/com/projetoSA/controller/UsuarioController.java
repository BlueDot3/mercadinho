package br.com.projetoSA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.projetoSA.model.Usuario;
import br.com.projetoSA.repository.UsuarioRepository;
import br.com.projetoSA.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	// Visualizar usuário

	@GetMapping("/usuario/view")
	public String viewUsuario(Model model, @CurrentSecurityContext(expression="authentication.name") String login) {

		model.addAttribute("usuario", usuarioRepository.findByLogin(login));

		return "usuario/view";
	}

	// Adicionar usuário

	@GetMapping("/usuario/add")
	public String addUsuario(Model model) {

		model.addAttribute("usuario", new Usuario());
		return "usuario/add";
	}

	@PostMapping("/usuario/save")
	public String saveAddUsuario(Usuario usuario) {

		usuarioService.saveUsuario(usuario);
		
		return "/login" ;	
	}

	// Editar usuário

	@GetMapping("/usuario/edit")
	public String editUsuario(Model model, @CurrentSecurityContext(expression="authentication.name") String login) {

		model.addAttribute("usuario", usuarioRepository.findByLogin(login));

		return "usuario/edit";
	}
	
	@PutMapping("/usuario/save")
	public String saveEditUsuario(Usuario usuario) {

		return usuarioService.updateUsuario(usuario);
	}
	
	// Deletar usuário

	@DeleteMapping("/usuario/delete")
	public String deleteUsuario(@CurrentSecurityContext(expression="authentication.name") String login) { 

		return usuarioService.deleteUsuario(login);
	}
}
