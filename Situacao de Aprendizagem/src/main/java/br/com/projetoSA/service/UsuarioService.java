package br.com.projetoSA.service;

import br.com.projetoSA.model.Usuario;

public interface UsuarioService {
    
    String saveAddUsuario(Usuario usuario);

    String deleteUsuario(String login);

    String saveEditUsuario(Usuario usuario);
}
