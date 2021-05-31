package br.com.projetoSA.service;

import java.util.List;


import br.com.projetoSA.model.Usuario;

public interface UsuarioService {
    
    String saveUsuario(Usuario usuario);

    String deleteUsuario(String login);

    String updateUsuario(Usuario usuario);
    
    public List<Usuario> findAll();
}
